#GRAFICADOR DE FUNCIONES USANDO PUNTOS

- Lenguaje Recomendado: Java
- ¿Razón? Cuenta con funciones como Graphics2D que pueden agilizar algunas cosas como la creacion del plano.

- ¿Qué debe hacer el programa?

1. Pedir al usario si quiere una funcion lineal o cuadratica
- Funcion de la Ecuacion Lineal: f(x) = ax + b
- Funcion Ecuacion Cuadratica: f(x) = ax^2 + bx + c

2. Pedir los valores de 'a', 'b' y de 'c' si es cuadratica.  

3. Mediante puntos mostrar en un cuadro de impresion de 400x400 pixeles el plano cartesiano.

4. Dependiendo de la funcion pedida convertir el plano real llevarlo al plano de pantalla, es decir calcular la escala que sera utilizada para mostrar la funcion. (NOTA: En el cuadro de impresion deben verse los puntos de corte con los ejes + un 15% extra de la funcion).

5. Para buscar la escala debemos dividir la cantidad de cm del plano real que ocuparemos entre la cantidad de pixeles que tiene el cuadro de impresion (en este caso 400). 
Por ejemplo: si yo abarco los puntos de la funcion entre -1 y +1 para hallar cuantos pixeles habra entre cada subdivision debo dividir 2/400, donde 2 representa los cm que hay entre -1 y +1 y 400 la cantidad de pixeles horizontales/verticales segun el caso.

6. Debo realizarlo mediante un menu de opciones para

   - 1.Funcion Lineal
   - 2.Funcion Cuadratica
   - 3.Salir

10. Fecha de Entrega: Viernes 24/11

## TO DO:

- [ ] Improve the code
- [ ] Add images to the README
- [ ] Update the README
- [ ] Write the README file in English
