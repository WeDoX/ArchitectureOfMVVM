package com.onedream.architecture_of_mvvm

import com.onedream.architecture.ui_state.UIState
import com.onedream.architecture.ui_state.UIStateHolder

class MainUIStateHolder : UIStateHolder() {
    val count = UIState(0)
}