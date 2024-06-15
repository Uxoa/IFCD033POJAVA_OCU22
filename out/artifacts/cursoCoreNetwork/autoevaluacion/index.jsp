<!DOCTYPE html>
<html>
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
    <title>Calcular Área</title>
  </head>
  <body>
  <h1>Calcular el Área de un Rectángulo</h1>
  <form action="CalcularArea" method="post">
    <label for="longitud">Longitud:</label>
    <input type="text" id="longitud" name="longitud" required>
    <br>
    <label for="ancho">Ancho:</label>
    <input type="text" id="ancho" name="ancho" required>
    <br>
    <input type="submit" value="Calcular">
  </form>
  </body>
  </html>

