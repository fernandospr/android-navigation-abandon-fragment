# android-navigation-abandon-fragment

This is a demo project to demonstrate a solution to call custom optional logic in your fragments when pressing back or navigateUp.

The demo contains three fragments:
* **AFragment**
* **BFragment**
* **CFragment**

**AFragment** and **CFragment** implement the `onAbandon()` method from the `AbandonListener` interface.
When pressing back or navigateUp, before going back, it'll call the `onAbandon()` method of the corresponding fragment, if the fragment implements the interface, otherwise it'll do nothing.

In this demo project, both fragments just print their class name.

### Adding a New Fragment

1. Create a new fragment.
2. Add the new fragment to the navigation graph file: **nav_graph.xml**.
3. Add an action to reach the new fragment in the navigation graph.
4. Implement the navigation in the **MainActivity.kt** file.
5. If you want to perform custom logic in your new fragment when the user presses back or navigateUp, just implement the `AbandonListener` interface.
