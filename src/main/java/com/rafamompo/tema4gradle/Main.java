package com.rafamompo.tema4gradle;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final String TOKEN = "";

        var modeloIA1 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey(TOKEN)
                .modelName("llama3.1:8b")
                .build();

        var modeloIA2 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey(TOKEN)
                .modelName("llama3.1:8b")
                .build();

        //Ejemplo de historial:
        List<ChatMessage> historialIA1 = new ArrayList<>();
        historialIA1.add(new UserMessage("Eres un comentarista profesional de videojuegos."));
        AiMessage mensajeIA1 = modeloIA1.chat(historialIA1).aiMessage();
        String pregunta = mensajeIA1.text();

        // El modeloloIA2 recibe la pregunta formulada por el
        // modeloIA1, generando una respuesta y la segunda IA extrae el texto generado por el modeloIA2
        String respuestaIA2 = modeloIA2.chat(List.of(new UserMessage(pregunta))).aiMessage().text();

        //Interaccion entre IAS:
        List<ChatMessage> historialIA2 = new ArrayList<>();
        historialIA1.add(new SystemMessage("Eres un experto en física cuántica."));

        System.out.println("IA1 pregunta: " + pregunta);
        System.out.println("IA2 responde: " + respuestaIA2);


    }
}
