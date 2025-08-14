# Task3_ChatApp
A Java TCP-based chat program supporting multiple clients connected to a single server.

**Default Port:** 1234 (custom port optional)

---

## 📂 File Structure

```
ChatApp/
├── Server.java
├── Client.java
└── chatServer$ClientHandler.java
```
A Java TCP-based chat program supporting multiple clients connected to a single server.

* **Default Port:** 1234 (custom port optional)
* **HOW TO Run:**

  * **Server:** `javac Server.java` → `java Server [port]`
  * **Client:** `javac Client.java` → `java Client [host] [port]`
* **Features:**

  1. **Broadcast:** Send message/file to all clients (`sendfile <filename>`).
  2. **Unicast:** Send message/file to a specific client (`@User:message` / `@User:sendfile file`).
  3. **Blockcast:** Send message/file to all except one client (`!User:message` / `!User:sendfile file`).
* **File Transfer:** Supports files up to \~250MB (increase Java heap size for larger files).
* **Notes:** Run server first; each client should have its own directory for file reception.Here’s your **README.md** in the short format you wanted, based on the chat application files you provided:
