# Ultron

[![Download](https://api.bintray.com/packages/alex-tiurin/espresso-page-object/espressopageobject/images/download.svg)](https://bintray.com/alex-tiurin/espresso-page-object/espressopageobject/_latestVersion)
![Android CI](https://github.com/alex-tiurin/ultron/workflows/AndroidCI/badge.svg)

Ultron is an easiest framework to develop Android UI tests. It makes your tests stable, short and understandable.
It's based on Espresso and UI Automator and it provides a lot of new great features.
Ultron also gives you a full control under your tests!

Moreover, you don't need to learn any new classes or special syntax. All magic actions and assertions are provided from crunch.
Ultron can be easially customised and extended. Wish you only stable tests!

![logo](https://user-images.githubusercontent.com/12834123/106507974-d8558c80-64dc-11eb-975b-ea76ddb27a37.png)

## What are the benefits of using the framework?

- Simple and presentative syntax
- Stability of all actions and assertions
- Full control under any action or assertion
- An architectural approach to writing tests
- Amazing mechanism of setups and teardowns (You even can setup preconditions for single test in test class. It won't affect the others))

## A few words about syntax

The standard Espresso syntax is complex and not intuitive to understand. This is especially evident when interacting with the RecyclerView

Let's look at 2 examples:

_1. Click on simple button._

**Clear Espresso**

```kotlin
onView(withId(R.id.send_button)).perform(click())
```
**Ultron**
```kotlin
withId(R.id.send_button).click()
```

_2. Click on RecyclerView list item_

**Clear Espresso**

```kotlin
onView(withId(R.id.recycler_friends))
    .perform(
        RecyclerViewActions
            .actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText("Janice")),
                click()
            )
        )
```
**Ultron**
```kotlin
withRecyclerView(R.id.recycler_friends)
    .atItem(hasDescendant(withText("Janice")))
    .click()
```
### You can get the result of any operation as boolean value

```kotlin
val isButtonDisplayed = withId(R.id.button).isSuccess { isDisplayed() }
if (isButtonDisplayed) {
    //do some reasonable actions
}
```
### You can customise a timeout of any operation

```kotlin
withId(R.id.result).withTimeout(10_000).hasText("Passed")
```

## 3 steps to write a test using Ultron

I try to advocate the correct construction of the test framework architecture, the division of responsibilities between the layers and other correct things.

Therefore, I would like to recommend the following approach when your are using Ultron.

1. Create a PageObject class and specify screen UI elements `Matcher<View>`.

```kotlin
object ChatPage : Page<ChatPage>() {
    private val messagesList = withId(R.id.messages_list)
    private val clearHistoryBtn = withText("Clear history")
    private val inputMessageText = withId(R.id.message_input_text)
    private val sendMessageBtn = withId(R.id.send_button)
}
```

It's recommended to make all PageObject classes as `object` and descendants of Page class.
In this case you will be able to use cool kotlin magic.

2. Describe user step methods in PageObject class.

```kotlin
object ChatPage : Page<ChatPage>() {
    fun sendMessage(text: String) = apply {
        inputMessageText.typeText(text)
        sendMessageBtn.click()
        this.getMessageListItem(text).text
             .isDisplayed()
             .hasText(text)
    }

    fun clearHistory() = apply {
        openContextualActionModeOverflowMenu()
        clearHistoryBtn.click()
    }
}
```
Full code sample [ChatPage.class](https://github.com/alex-tiurin/ultron/blob/master/sample-app/src/androidTest/java/com/atiurin/sampleapp/pages/ChatPage.kt)

3. Call user steps in test

```kotlin
    @Test
    fun friendsItemCheck(){
        FriendsListPage {
            assertName("Janice")
            assertStatus("Janice","Oh. My. God")
        }
    }
    @Test
    fun sendMessage(){
        FriendsListPage.openChat("Janice")
        ChatPage {
            clearHistory()
            sendMessage("test message")
        }
    }
```

In general, it all comes down to the fact that the architecture of your project will look like this.

![Architecture](https://github.com/alex-tiurin/espresso-page-object/blob/master/wiki/img/architecture.png)

## Add to your project
Gradle
```groovy
repositories {
    jcenter()
}

dependencies {
    androidTestImplementation 'com.atiurin.espresso:espressopageobject:0.1.19'
}
```
Maven
```
<dependency>
  <groupId>com.atiurin.espresso</groupId>
  <artifactId>espressopageobject</artifactId>
  <version>0.1.19</version>
  <type>pom</type>
</dependency>
```

## AndroidX

It is required to use AndroidX libraries. You can get some problems with Android Support ones.
