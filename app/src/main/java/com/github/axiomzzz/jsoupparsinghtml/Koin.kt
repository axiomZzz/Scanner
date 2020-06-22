package com.github.axiomzzz.jsoupparsinghtml

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {
    viewModel{RootViewModel()}
}