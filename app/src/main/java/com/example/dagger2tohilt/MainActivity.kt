package com.example.dagger2tohilt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dagger2tohilt.data.repository.RepositoryImpl
import com.example.dagger2tohilt.databinding.ActivityMainBinding
import com.example.dagger2tohilt.di.AppComponent
import com.example.dagger2tohilt.di.DaggerAppComponent
import com.example.dagger2tohilt.domain.repository.Repository
import com.example.database.data.TodoDao
import com.example.database.domain.models.Todo
import com.example.database.presentation.WorkActivity
import com.example.network.di.DaggerNetworkComponent
import com.example.network.di.NetworkComponent
import com.example.network.remote.ApiService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val networkComponent: NetworkComponent by lazy {
        DaggerNetworkComponent.builder()
            .application(application)
            .build()
    }
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(application)
            .networkComponent(networkComponent)
            .build()
    }

    @Inject
    lateinit var api: ApiService
    lateinit var repository: Repository

    @Inject
    lateinit var todoDao: TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        appComponent.inject(this)
        repository = RepositoryImpl(api)
        initViews()
    }

    private fun initViews() = with(binding) {
        btn.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() = lifecycleScope.launch {
        val data = repository.getTodo()
        Todo(
            title = data.title,
            completed = data.completed,
            userId = data.userId
        ).let {
            withContext(Dispatchers.IO) { todoDao.insert(it) }
        }
        val text = withContext(Dispatchers.IO) { todoDao.getAll()[0].title }
        binding.resultText.text = text
//        val intent = Intent(this@MainActivity, WorkActivity::class.java)
//        startActivity(intent)
    }
}