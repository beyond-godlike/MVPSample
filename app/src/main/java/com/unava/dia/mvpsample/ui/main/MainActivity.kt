package com.unava.dia.mvpsample.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unava.dia.mvpsample.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainActivityContract.MainActivityView {

    @Inject
    internal lateinit var presenter: MainActivityPresenter

    private val GREETING = "greeting"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        btCommonGreeting.setOnClickListener {
            onCommonGreetingButtonClicked()
        }
        btLobbyGreeting.setOnClickListener {
            onLobbyGreetingButtonClicked()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (!TextUtils.isEmpty(tvGreeting.text)) {
            outState.putCharSequence(GREETING, tvGreeting.text)
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        tvGreeting.text = savedInstanceState.getCharSequence(GREETING)
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onCommonGreetingButtonClicked() {
        presenter.loadCommonGreeting()
    }

    override fun onLobbyGreetingButtonClicked() {
        presenter.loadLobbyGreeting()
    }

    override fun displayGreeting(greeting: String) {
        tvGreeting.visibility = View.VISIBLE
        tvGreeting.text = greeting
    }

    override fun hideGreeting() {
        tvGreeting.visibility = View.GONE
    }

    override fun displayGreetingError(throwable: Throwable) {
        Timber.e(throwable.message)
        Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show()
    }

    override fun setLoadingIndicator(active: Boolean) {
        loadingIndicator.visibility = if (active) View.VISIBLE else View.GONE
    }
}
