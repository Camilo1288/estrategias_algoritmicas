# Estrategias algorítmicas - Lógica de Programación 2

Estudiante: Camilo Tarazona Orozco

## Actividades
- Actividad 1: `Inversions` (Divide y Vencerás, número de inversiones)
- Actividad 2: `MoneyChangeDP` (Programación Dinámica, monedas 1, 3 y 4)
- Actividad 3: `MoneyChangeGreedy` (Voraz, monedas 1, 5 y 10)
- Actividad 4: tabla comparativa (esta página)

Las clases están en `src/main/java/com/lasalle/estrategias_algoritmicas`. Las capturas de ejecución de cada actividad están en el repositorio.

## Tabla comparativa

| Criterio | Divide y Vencerás | Programación Dinámica | Algoritmos Voraces |
|---|---|---|---|
| Idea | Dividir en subproblemas independientes, resolver y combinar | Resolver subproblemas pequeños, guardarlos en una tabla y construir los grandes | Elegir la mejor opción local en cada paso, sin retroceder |
| Esquema | Recursivo (top-down) | Iterativo (bottom-up) o recursivo con memorización | Iterativo, por etapas |
| Subproblemas | Independientes | Se solapan, por eso se guardan | No plantea subproblemas |
| Óptimo garantizado | Sí, si la división y la combinación son correctas | Sí, si cumple el principio de optimalidad de Bellman | No siempre, hay que demostrarlo |
| Eficiencia (tiempo) | Inversions: O(n log n) frente a O(n²) de la versión ingenua | MoneyChangeDP: O(money · k), con k = número de monedas | MoneyChangeGreedy: O(k), la más rápida |
| Memoria | O(n) por el arreglo auxiliar, más la pila de recursión O(log n) | O(money) por la tabla minCoins | O(1), solo variables simples |
| Ventajas | Simple, legible, reduce la complejidad | Evita recalcular, baja costos exponenciales a polinomiales | Fácil de implementar y muy eficiente |
| Desventajas | Usa más pila del sistema | Necesita memoria extra y un espacio de parámetros discreto | Puede dar soluciones subóptimas |

## Ejemplo: el voraz no siempre es óptimo
Con monedas {1, 3, 4} y cantidad 6, el voraz da 4+1+1 = 3 monedas, pero la programación dinámica da 3+3 = 2 monedas. Con monedas {1, 5, 10} el voraz sí es óptimo.









































