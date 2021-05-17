# TierraFantasia
Consigna
Reglas
Las razas entregadas deben estar completas. Sólo se permitirá una raza incompleta (la última en la que hayan trabajado).
Cada raza debe poder atacar, descansar y recibirAtaque. Cualquiera de estas acciones será considerada como un turno.
Solamente habrá puntaje si se evidencia el correcto funcionamiento de la funcionalidad mediante suficientes pruebas unitarias.

Puntuación
Se otorgarán:
+3 XP por habilidad (atacar, descansar, recibirAtaque) probada.
+3 XP extra por raza completa.
+8 XP por las cuatro razas completas.
Se restarán todos los puntos si se detecta código copiado o estructuralmente equivalente entre grupos (a.k.a. copiado)

Tips
Utilizar herencia y polimorfismo ayuda, pero no hasta descubrir un patrón de comportamiento.
Para probar más fácilmente, quizás conviene utilizar una raza adicional, “sabor a vainilla”. Es decir, que al atacar siempre lo hace con el mismo valor, y al recibir ataque siempre impacta directamente.
No hay un orden específico para las razas, y todas puntúan igual: elijan sabiamente por dónde empezar.

Razas

Un Gricean tiene una salud inicial de 96. Utiliza sus manos, y su rango de ataque es de menos de 12 metros. Ocasiona un daño básico de 67 puntos. Cuando ataca, lo hace con 1/4 de daño, cada 2 ataques. Al recibir un ataque se desconcentra y sus ataques vuelven al valor normal inicial. Cuando descansa, se concentra y sus próximos 3 ataques dañan el cuadruple del valor correspondiente.

Una Radaiteran tiene una salud inicial de 192. Utiliza un arco, y su rango de ataque es de 7 a 48 metros. Ocasiona un daño básico de 84 puntos. Cuando ataca, lo hace cada vez con más fuerza (2 de daño extra x la cantidad de ataques dados). Al recibir un ataque se enfurece y sus ataques multiplican por 2 su daño (dura 2 turnos). Cuando descansa, medita, y como considera la violencia como algo malo, se rehúsa a atacar hasta que lo ataquen. Gracias a esto, aumenta su salud y su salud máxima en 25.

Un Hudin tiene una salud inicial de 196. Utiliza una catapulta, y su rango de ataque es de 7 a 42 metros. Ocasiona un daño básico de 49 puntos. Cuando ataca, envenena a su enemigo y éste pierde 2 de salud por turno. Al recibir un ataque lo hace normalmente. Cuando descansa, recupera toda su salud, pero se vuelve de piedra por 3 turnos, lo que hace que no pueda atacar, pero reduce el daño entrante en 3/4.

Una Bixuver tiene una salud inicial de 103. Utiliza una alabarda, y su rango de ataque es de menos de 3 metros. Ocasiona un daño básico de 87 puntos. Cuando ataca, se cura un 2 por ciento de su salud. Al recibir un ataque recibe 1/6 del daño, ya que tiene mucha armadura. Cuando descansa, reduce el daño del siguiente ataque recibido, en 1/2.

Efectos
El efecto de veneno se cura cuando se descansa. El veneno daña después de que se apliquen las consecuencias de un ataque y de un recibir ataque
