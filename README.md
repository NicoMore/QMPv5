# QMP

# Primer Iteracion
Requerimientos primera iteracion:
    -Cargar prendas validas. ✓
    -Especificar tipo de prenda.  ✓
    -Identificar categoria de prenda. ✓
    -Indicar material/tela. ✓
    -Indicar color. ✓
    -Indicar opcionalmente color secundario. ✓
    -Requerimientos no marcados opcionales son necesarios. ✓
    -Tipo se asocia con categoria. ✓

Decisiones en Primera Iteracion:
    -Como funcionamiento de Atuendo no es especificado, queda como boceto para entender funcionamiento de prenda.
    -Funcionamientos de Prenda como factory, al tener distintas categorias inmutables con comportamiento diferenciado.
    -Tipos de prenda no especificados al no tener los distintos tipos, utilizado "conceptualmente".
    -Caracteristicas de prendas pedidas "en tiempo real" para mas "personalizacion", ademas que las hace obligatorias y no pueden ser salteadas.

# Segunda Iteracion
Requerimientos segunda iteracion:
    -Especificar trama de tela. ✓
    -Iniciar creacion de prenda por el tipo. ✓
    -Segunda etapa de creacion sera sobre el material. ✓
    -Poder guardar borrador. ✓
    -Trama default es lisa. ✓
    -Guardar prenda solo si es valida. ✓ Es valida por default al hacer verificaciones a lo largo de la creacion
    -Poder recibir sugerencias de uniformes. ✓
    -Uniforme sera prenda superior, inferior y calzado. ✓
    -Posibilitar configuracion de uniformes especificos. ✓

Pasos para integrar la primera iteracion en la segunda:
    -Unificar seleccion de tipos y categorias en un paso, al ser dependientes. ✓
    -Hacer lista de prendas agregadas. ✓

Decisiones en Segunda Iteracion:
    -Se paso de un factory a un builder (ademas de destruir las pequeñas factories).
    -Tipos de prenda definidos como Strings.

# Cuarta Iteracion
Requerimientos cuarta iteracion:
    -Conocer clima Bs As para sugerencias. ✓
    -Recibir sugerencia de atuendo con prenda de cada categoria.✓
    -Prendas acorde a temperatura en sugerencia. ✓
    -Administrador desea configurar distintos servicios de obtencion de clima. ✓
    -Stakeholder asegurar calidad sin costos innecesarios.

Pasos para integrar la segunda iteracion en la cuarta:
    -Integrar borrador directamente en el builder. ✓
    -Cambiar manejo de Uniformes con factory method. ✓

Decisiones en cuarta iteracion:
    -Meteorologo como strategy para manejo de distintos servicios.
    -Interfaz servicio como adapter para usar las distintas apis.
    -Temperatura como clase para soportar distintos formatos y menor repeticion de codigo, mismo caso con Clima.
    -Prenda mutable si atributos nulos, para soportar manejo de borradores (1 por vez), manteniendo inmutabilidad.
    -Todos los metodos de Prenda pasados al builder para mayor coherencia.
    -Creacion de una PrendaFallada, para soluciones polimorficas de fallos.