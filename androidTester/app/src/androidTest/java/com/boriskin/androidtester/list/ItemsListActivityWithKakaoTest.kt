package com.boriskin.androidtester.list

import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.boriskin.androidtester.LifecycleTest
import com.boriskin.androidtester.instances.ItemsListScreenInstance
import org.junit.Test

private const val LIST_SIZE = 20

class ItemsListActivityWithKakaoTest :
        LifecycleTest<ItemsListActivity>(ItemsListActivity::class.java) {

    override fun onSetup() = Unit

    @Test
    fun checkThatOnStartListHas20ItemsByDefault() {
        onScreen<ItemsListScreenInstance> {
            recycler {
                hasSize(LIST_SIZE)
            }
        }
    }

    @Test
    fun checkThatItemsListHasCorrectTitle() {
        onScreen<ItemsListScreenInstance> {
            recycler {
                firstChild<ItemsListScreenInstance.Item> {
                    // ViewGroup и дочерние элементы
                    isVisible()
                    title {
                        hasText("Element 0")
                    }
                }
            }
        }
    }

    @Test
    fun checkThatAfterClickOnItemItDisappear() {
        onScreen<ItemsListScreenInstance> {
            recycler {
                firstChild<ItemsListScreenInstance.Item> {
                    click()
                }
                assert(getSize() == LIST_SIZE - 1)
            }
        }
    }
}
