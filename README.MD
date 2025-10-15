# Preguntas de reflexion
**1. ¿Que ventajas obtuviste al dividir la logica en metodos cortos en lugar de un "metodo dios"?**
Dividir el codigo en metodos cortos me permite mantener el programa mas ordenado y facil de 
entender. Cada metodo tiene una unica responsabilidad, por lo que se puede modificar o revisar
una parte sin afectar el resto. Ademas, el codigo se vuelve mas reutilizable y es mas simple 
detectar errores o agregar nuevas funcionalidades, como las estadisticas o validaciones.

**2. ¿Como te ayudaron los arreglos a listar y analizar resultados?**
Los arreglos sirvieron para guardar los datos de cada ronda(numero, apuesta y acierto), lo que
hizo posible calcular estadisticas despues. Gracias a ellos, se pudieron recorrer los resultados,
sumar los montos, contar aciertos y obtener porcentajes sin usar estructuras mas complejas.
Asi fue mas facil registrar la historia del juego y mostrar los totales.

**3. ¿Que diferencias notaste al trabajar con un enfoque Top-down frente a Bottom-up?**
Con el enfoque Top-down comence diseñando el programa desde lo general (el menu principal y el
flujo del juego) y luego fui creando los metodos que necesitaba para que funcionara cada parte.
Esto ayudo a planificar mejor la estructura y evitar confuciones. En cambio, un enfoque 
Bottom-up habria significado construir funciones pequeñas primero sin ver el panorama completo,
lo que podria haber sido mas desordenado en este tipo de tarea.
