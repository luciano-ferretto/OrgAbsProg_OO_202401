package br.edu.atitus.denguealertaexp.controllers;
import java.io.*;
import java.net.*;

public class SimpleHTTPServer {
    public static void main(String[] args) {
        try {
            // Cria um servidor socket na porta 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor HTTP iniciado na porta 8080...");

            while (true) {
                // Aceita uma conexão
                Socket clientSocket = serverSocket.accept();

                // Processa a conexão em uma nova thread
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            // Lê a primeira linha da requisição (request line)
            String inputLine = in.readLine();
            if (inputLine != null) {
                // Verifica se a requisição é GET ou POST
                if (inputLine.startsWith("GET")) {
                    // Ignora os headers restantes
                    while ((inputLine = in.readLine()) != null && !inputLine.isEmpty()) {
                        // Nada a fazer aqui, apenas consumir as linhas
                    }

                    // Responde com um simples HTML
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println();
                    out.println("<html><body>");
                    out.println("<h1>Hello World! - Aula Java 10/06</h1>");
                    out.println("</body></html>");
                } else if (inputLine.startsWith("POST")) {
                    int contentLength = 0;
                    String line;
                    // Lê os headers para obter o Content-Length
                    while (!(line = in.readLine()).isEmpty()) {
                        if (line.startsWith("Content-Length:")) {
                            contentLength = Integer.parseInt(line.split(" ")[1]);
                        }
                    }

                    // Lê o corpo da requisição
                    char[] body = new char[contentLength];
                    in.read(body, 0, contentLength);
                    String requestBody = new String(body);

                    // Processa o JSON recebido
                    String nome = null;
                    String email = null;
                    if (requestBody.contains("\"nome\":")) {
                    	var nomes = requestBody.split("\"nome\":\"");
                        nome = requestBody.split("\"nome\":\"")[1].split("\"")[0];
                    }
                    if (requestBody.contains("\"email\":")) {
                        email = requestBody.split("\"email\":\"")[1].split("\"")[0];
                    }

                    // Responde com um simples HTML confirmando o recebimento dos dados
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println();
                    out.println("<html><body>");
                    out.println("<h1>Dados Recebidos</h1>");
                    out.println("<p>Nome: " + nome + "</p>");
                    out.println("<p>Email: " + email + "</p>");
                    out.println("</body></html>");
                }
            }

            // Fecha a conexão com o cliente
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}