Observable
===

_Observer_ abboniert einen _Observable_.

_Observable_ veröffentlicht ein Item oder eine Ansammlung von Items 
und der _Observer_ reagiert drauf (non-blocking).

Hintergrund
===

In der Programmierung erwartet man Ergebnisse nach Instruktionen in der Reihenfolge wie sie niedergeschrieben sind.
In ReactiveX können viele Instruktionen parallel ausgeführt, und ihr Ergebnis später verarbeitet werden, und zwar dann,
wenn das Ergebnis vorliegt. Die Reihenfolge ist nicht vorhersehbar.

Gegeben seien einige Tasks die nicht voneinander abhängig sind, anstatt auf jedes Ergebnis nacheinander warten zu müssen,
führt man die Tasks parallel durch. Somit ist die Gesamtlaufzeit so hoch wie der Task der am längsten gedauert hat,
anstatt die Summe der Laufzeiten aller Tasks.

**Abonnieren führt die Aktion des Observables aus**

onNext (0..n calls)
===
Ein Observable ruft onNext auf, wenn dieser ein Item ausliefert.
Dieses Item wird an onNext übermittelt.

onError
===
Ein Observable ruft onError auf, wenn die Verarbeitung abgebrochen wird.

onCompleted
===
Ein Observable ruft diese Methode nach dem letzten Call von onNext.
