package com.rafamompo.tema4gradle;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Configuración de los modelos IA
        var modeloIA1 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .modelName("llama3.1:8b")
                .build();

        var modeloIA2 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .modelName("llama3.1:8b")
                .build();

        // ----------------------------
        // Interacción IA1 → IA2 → IA1
        // ----------------------------

        // Inicializamos la "personalidad" de la IA1
        List<SystemMessage> historialIA1 = new ArrayList<>();
        historialIA1.add(new SystemMessage("Eres un comentarista profesional de videojuegos."));

        // Primera pregunta de IA1
        String pregunta1 = modeloIA1.chat("Hola, soy Rafa. Cuéntame un consejo sobre shooters online.");
        // IA2 responde a IA1
        String respuesta1IA2 = modeloIA2.chat("Pregunta de IA1: " + pregunta1);
        // IA1 responde a IA2 (segunda interacción)
        String respuesta2IA1 = modeloIA1.chat("Respuesta de IA2: " + respuesta1IA2 + " Dame tu opinión.");
        // IA2 responde de nuevo a IA1 (segunda interacción)
        String respuesta2IA2 = modeloIA2.chat("Comentario de IA1: " + respuesta2IA1 + " ¿Qué piensas ahora?");


        // ----------------------------
        // Mostrar todo por pantalla
        // ----------------------------
        System.out.println("IA1 pregunta1: " + pregunta1);
        System.out.println("IA2 responde1: " + respuesta1IA2);
        System.out.println("IA1 responde2: " + respuesta2IA1);
        System.out.println("IA2 responde2: " + respuesta2IA2);

    }
}
