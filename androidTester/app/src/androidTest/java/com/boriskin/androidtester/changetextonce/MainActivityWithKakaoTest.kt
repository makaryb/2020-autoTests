package com.boriskin.androidtester.changetextonce

import android.util.Log
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.Kakao
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.boriskin.androidtester.ChangeTextOnceActivity
import com.boriskin.androidtester.instances.HomeScreenInstance
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityWithKakaoTest {

    @Before
    fun setup() {
        launchActivity<ChangeTextOnceActivity>()
        Kakao {
            invoke {
                // Runtime
            }

            intercept {
                onViewInteraction {
                    onPerform { interaction, action ->
                        Log.d("WITH KAKAO", "$interaction is performing $action")
                    }
                }
            }

            // Сброс всех интерцепторов
            reset()
        }
    }

    @Test
    fun checkThatMainTextFieldChangeTextAfterClickedOnButton() {
        onScreen<HomeScreenInstance> {
            button {
                click()
            }
            field {
                hasText("Clicked")
            }
        }
    }
}
