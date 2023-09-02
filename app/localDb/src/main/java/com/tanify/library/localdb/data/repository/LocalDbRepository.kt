package com.tanify.library.localdb.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import com.tanify.library.localdb.data.dto.WhiteListAppDto
import com.tanify.library.localdb.data.dto.toModel
import com.tanify.library.localdb.domain.datasource.LocalDbDataSource
import com.tanify.library.localdb.domain.model.WhiteListAppModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDbRepository @Inject constructor(
    private val context: Context
) : LocalDbDataSource{
    @SuppressLint("QueryPermissionsNeeded")
    override fun getAllAppDevice(): Flow<List<WhiteListAppModel>> {
        return flow {
            val appList = mutableListOf<WhiteListAppDto>()

            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)

            val packageManager = context.packageManager
            val resolverInfoList = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageManager.queryIntentActivities(
                    intent, PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())
                )
            } else {
                packageManager.queryIntentActivities(intent, PackageManager.GET_META_DATA)
            }

            for(resolveInfo in resolverInfoList) {
                val packageName = resolveInfo.activityInfo.packageName
                val appName = resolveInfo.loadLabel(packageManager).toString()
                val appIcon = resolveInfo.loadIcon(packageManager)
                val instance = WhiteListAppDto(packageName, appName, appIcon)

                appList.add(instance)
            }

            if(appList.isNotEmpty()) {
                emit(appList.map {
                    it.toModel()
                })
            }
        }
    }
}