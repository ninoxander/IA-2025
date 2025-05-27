; --- Templates ---

(deftemplate paciente
    (slot nombre)
    (slot sintoma1)
    (slot sintoma2)
    (slot sintoma3)
    (slot sintoma4))

(deftemplate diagnostico
    (slot enfermedad))

(deftemplate tratamiento
    (slot medicamento1)
    (slot medicamento2))

(deftemplate analisis
    (slot estudio1)
    (slot estudio2))

; --- Estado inicial ---

(deffacts estado-inicial
    (paciente 
        (nombre "Paciente1")
        (sintoma1 fiebre)
        (sintoma2 tos)
        (sintoma3 fatiga)
        (sintoma4 dolor-cabeza)))

; --- Reglas de diagnostico ---

(defrule diagnosticar-gripe
    (paciente (sintoma1 fiebre) (sintoma2 tos) (sintoma3 fatiga) (sintoma4 dolor-cabeza))
    =>
    (assert (diagnostico (enfermedad gripe)))
    (printout t "Diagnostico: Gripe detectada." crlf)
    (assert (tratamiento (medicamento1 antipireticos) (medicamento2 reposo)))
    (assert (analisis (estudio1 "Prueba de influenza") (estudio2 none))))

(defrule diagnosticar-neumonia
    (paciente (sintoma1 fiebre-alta) (sintoma2 dificultad-respirar) (sintoma3 dolor-toracico))
    =>
    (assert (diagnostico (enfermedad neumonia)))
    (printout t "Diagnostico: Neumonia detectada." crlf)
    (assert (tratamiento (medicamento1 antibioticos) (medicamento2 none)))
    (assert (analisis (estudio1 "Radiografia pulmonar") (estudio2 "Prueba de sangre"))))

(defrule diagnosticar-faringitis
    (paciente (sintoma1 dolor-garganta) (sintoma2 fiebre) (sintoma3 inflamacion-ganglionar))
    =>
    (assert (diagnostico (enfermedad faringitis-estreptococica)))
    (printout t "Diagnostico: Faringitis Estreptococica detectada." crlf)
    (assert (tratamiento (medicamento1 antibioticos) (medicamento2 analgesicos)))
    (assert (analisis (estudio1 "Cultivo de garganta") (estudio2 none))))

(defrule diagnosticar-covid
    (paciente (sintoma1 fiebre) (sintoma2 tos-seca) (sintoma3 perdida-olfato-gusto))
    =>
    (assert (diagnostico (enfermedad covid-19)))
    (printout t "Diagnostico: COVID-19 detectado." crlf)
    (assert (tratamiento (medicamento1 antipireticos) (medicamento2 aislamiento)))
    (assert (analisis (estudio1 "Prueba PCR COVID") (estudio2 "Prueba rapida antigenos"))))

; --- Imprimir tratamiento ---

(defrule imprimir-tratamiento
    (tratamiento (medicamento1 ?m1) (medicamento2 ?m2))
    =>
    (printout t "Tratamiento recomendado:" crlf)
    (printout t "- " ?m1 crlf)
    (if (neq ?m2 none) then
        (printout t "- " ?m2 crlf)))

; --- Imprimir analisis ---

(defrule imprimir-analisis
    (analisis (estudio1 ?e1) (estudio2 ?e2))
    =>
    (printout t "Analisis clinicos recomendados:" crlf)
    (printout t "- " ?e1 crlf)
    (if (neq ?e2 none) then
        (printout t "- " ?e2 crlf)))
