package com.example.util.simpletimetracker.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.util.simpletimetracker.domain.di.AppContext
import com.example.util.simpletimetracker.ui.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RouterImpl @Inject constructor(
    private val screenResolver: ScreenResolver,
    private val actionResolver: ActionResolver,
    private val notificationResolver: NotificationResolver,
    @AppContext private val context: Context
) : Router {

    private var navController: NavController? = null
    private var activity: Activity? = null

    override fun bind(activity: Activity) {
        this.navController = activity.findNavController(R.id.container)
        this.activity = activity
    }

    override fun navigate(screen: Screen, data: Any?, sharedElements: Map<Any, String>?) {
        screenResolver.navigate(navController, screen, data, sharedElements)
    }

    override fun execute(action: Action, data: Any?) {
        actionResolver.execute(activity, action, data)
    }

    override fun show(notification: Notification, data: Any?, anchor: Any?) {
        notificationResolver.show(activity, notification, data, anchor)
    }

    override fun back() {
        navController?.navigateUp()
    }

    override fun getMainStartIntent(): Intent {
        return Intent(context, MainActivity::class.java)
    }
}