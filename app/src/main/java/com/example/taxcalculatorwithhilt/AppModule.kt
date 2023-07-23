package com.example.taxcalculatorwithhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // SingletonComponentはアプリケーション全体で有効なコンポーネント
object AppModule {
    @Provides
    @Singleton
    fun provideTaxCalculator(): TaxCalculator {
        return TaxCalculator()
    }
}