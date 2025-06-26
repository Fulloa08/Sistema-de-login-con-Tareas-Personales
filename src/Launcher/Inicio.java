package Launcher;

import Vista.LoginView;

import javax.swing.*;

public class Inicio {
    public static void main(String[] args) {
        // Asegura que la GUI se cargue en el hilo correcto
        SwingUtilities.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
