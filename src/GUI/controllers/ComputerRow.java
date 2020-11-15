/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

/**
 *
 * @author ion
 */
 public class ComputerRow {

        public String id;
        public String nombreEdificio;
        public String idEdificio;
        public String nombreSala;

        public ComputerRow(String id, String idEdificio, String nombreEdificio,  String nombreSala) {
            this.id = id;
            this.nombreEdificio = nombreEdificio;
            this.idEdificio = idEdificio;
            this.nombreSala = nombreSala;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombreEdificio() {
            return nombreEdificio;
        }

        public void setNombreEdificio(String nombreEdificio) {
            this.nombreEdificio = nombreEdificio;
        }

        public String getIdEdificio() {
            return idEdificio;
        }

        public void setIdEdificio(String idEdificio) {
            this.idEdificio = idEdificio;
        }

        public String getNombreSala() {
            return nombreSala;
        }

        public void setNombreSala(String nombreSala) {
            this.nombreSala = nombreSala;
        }

    }
