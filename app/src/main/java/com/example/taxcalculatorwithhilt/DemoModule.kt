package com.example.taxcalculatorwithhilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object DemoModule {
    @Provides
    fun provideDemoUtil(@ApplicationContext context: Context): DemoUtil {
        return DemoUtil(context, "Hi!")
    }
}