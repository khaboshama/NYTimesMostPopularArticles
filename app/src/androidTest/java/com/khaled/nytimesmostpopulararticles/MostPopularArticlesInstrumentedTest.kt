package com.khaled.nytimesmostpopulararticles

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.khaled.nytimesmostpopulararticles.model.ArticleItem
import com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view.MostPopularArticlesActivity
import com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view_model.MostPopularArticlesViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MostPopularArticlesInstrumentedTest {


    @get:Rule
    var mActivityRule: ActivityTestRule<MostPopularArticlesActivity> =
        ActivityTestRule(MostPopularArticlesActivity::class.java)

    private lateinit var viewModel: MostPopularArticlesViewModel
    private lateinit var articleItem: ArticleItem
    private val mediaUrl: String = "https://static01.nyt.com/images/2020/11/24/opinion/00mmPromo/00mmPromo-mediumThreeByTwo440.jpg"
    private val publishedDate = "25-5-2020"
    private val author = "By Khaled Ismail"
    private val title = "First App"
    private val description = "Android App using coroutine"

    @Before
    fun setup() {
        viewModel = ViewModelProvider(mActivityRule.activity).get(MostPopularArticlesViewModel::class.java)
        articleItem = ArticleItem(1, publishedDate, author, title, description, mediaUrl)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.khaled.nytimesmostpopulararticles", appContext.packageName)
        Thread.sleep(5000)
    }

    @Test
    fun test_recyclerView_is_empty() {
        assertEquals(getArticleListSize(), 20)
        Thread.sleep(5000)
    }

    @Test
    fun test_navigate_to_article_details() {
        viewModel.navigateToArticleScreenLiveData.postValue(articleItem)
        onView(withId(R.id.title_text_view)).check(matches(withText(title)));
        onView(withId(R.id.date_text_view)).check(matches(withText(publishedDate)));
        onView(withId(R.id.author_text_view)).check(matches(withText(author)));
        onView(withId(R.id.description_text_view)).check(matches(withText(description)));
        Thread.sleep(5000)
    }

    private fun getArticleListSize(): Int {
        val recyclerView =
            mActivityRule.activity.findViewById<View>(R.id.articles_recycler_view) as RecyclerView
        return recyclerView.adapter!!.itemCount
    }
}