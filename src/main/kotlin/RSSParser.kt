import com.sun.syndication.feed.synd.SyndEntryImpl
import com.sun.syndication.io.SyndFeedInput
import com.sun.syndication.io.XmlReader
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import java.net.URL

suspend fun parseRssFeed(url: String) = withTimeoutOrNull(1500L) {
    val input = SyndFeedInput()
    val feedUrl = URL(url)
    val feed = input.build(XmlReader(feedUrl))

    val deferredNews: Deferred<List<String>?> =
        async {
            feed.entries.map { (it as SyndEntryImpl).title }
        }
    val newsTitles = deferredNews.await()
    if (newsTitles != null) println("Заголовки постов\n")
    newsTitles?.forEach { println(it) }

}

fun main(): Unit = runBlocking {
    val rssUrl = "https://westernin.livejournal.com/data/rss"
    parseRssFeed(rssUrl)
}

