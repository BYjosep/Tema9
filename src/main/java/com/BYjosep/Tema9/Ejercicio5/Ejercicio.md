Queremos guardar la información de un conjunto de pacientes para posteriormente obtener datos
estadísticos. De cada paciente queremos guardar un identificador (autonumérico), nombre, la
fecha de nacimiento (dd/mm/yyyy), el sexo (únicamente se admiten los valores 'M' o 'F'; por
defecto estará a 'M'), la altura (en metros) y el peso (Kg). Constructor con todos los datos.
El programa deberá cumplir los siguientes requisitos:

> - [x] a) Un método llamado `majorMenor`, que recibirá una lista de pacientes y devolverá un array de 2
 números enteros. La primera componente del Array devuelto guardará la posición del paciente
 más pequeño (en edad) y en la segunda componente se guardará la posición del paciente más
 mayor (también en edad).

> - [x] b) Tendrá un método llamado `pacientsPerSexe` que, como en el caso anterior, recibirá una lista de
 pacientes y devolverá un Array de 2 números enteros. La primera componente del Array
 devuelto guardará la cantidad de hombres y la segunda componente guardará la cantidad de
 mujeres.

> - [x] c) Un método para calcular el índice de masa corporal (IMC). Este índice se calcula a partir de la
 siguiente fórmula:
 $IMC = pes / (altura*altura)$
 El método se aplica sobre un paciente y devuelve un double.

> - [X] d) Un método para calcular la edad en años de los pacientes. Esta edad será la que se mostrará en el toString del paciente.

> - [x] e) Un método que, a partir del índice de masa corporal, visualice el mensaje que corresponda
 según la siguiente tabla:
>
>
>	| IMC | Mensaje|
>	| --- | --- |
>	| <18.5 | Peso insuficiente |
>	| 18.5-24.9 | Peso normal |
>	| 25-26.9 | Sobrepeso grado I |
>	|27-29.9 | Sobrepeso grado II|
>	| >29.9 | Sobrepeso grado III |

> - [ ] f) Implementar