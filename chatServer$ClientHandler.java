package Task3_ChatApp;

import java.io.*;
import java.net.*;

// Inner class of ChatServer
class ClientHandler implements Runnable {
    private final Socket socket;
    private final ChatServer server;
    private PrintWriter out;
    private String userName;

    ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try (
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        ) {
            out = new PrintWriter(socket.getOutputStream(), true);

            // Ask client for a name
            out.println("Enter your name: ");
            userName = reader.readLine();
            if (userName == null || userName.trim().isEmpty()) {
                userName = "User" + socket.getPort();
            }

            server.broadcast(userName + " has joined the chat.", this);

            String message;
            while ((message = reader.readLine()) != null) {
                if ("quit".equalsIgnoreCase(message)) {
                    break;
                }
                server.broadcast(userName + ": " + message, this);
            }

        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
        } finally {
            server.removeClient(this);
            server.broadcast(userName + " has left the chat.", this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}