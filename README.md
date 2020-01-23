# Glycemic

Aplikacja powstała na potrzeby przedmiotu MobileProgramming. Jej celem jest wspieranie cukrzyków oraz osoby będące na diecie w utrzymaniu odpowiedniego poziomu glikemii.

W aplikacji można wyodbrębnić 5 podstawowych modułów (zakładek), reprezentowanych w postaci klikalnych elementów na dolnym pasku nawigacji:
- **Info** 
    - podstawowe informacje na temat indeksu glikemicznego 
    - implementacja w postaci WebView, który jako url przyjął artykuł ze Strony Lekarze Bez Kolejki
    
- **Dodaj** 
    - zakładka umożliwiająca dodawanie specyficznego do globalnej bazy produktów z indeksem glikemicznym 
    - reprezentacja w postaci widoku z 6 edytowalnymi polami, po których wypełnieniu (nasłuch na każdym polu) odblokowany zostaje przycisk Dodaj. Naciśnięcie przycisku Dodaj powoduje zbudowanie obiektu Product i zapisanie go w Realtime Database natychmiastowo - produkt jest od razu widoczny na liście produktów. Ponadto użytkownik otrzymuje powiadomieniem Toastem o udanej operacji. Na końcu czyszczony jest formularz.
    
- **Produkty** 
    - lista produktów ze zdjęciem, nazwą i indeksem glikemicznym 
    - implementacja listy w postaci ListView, dane są ciągle nasłuchiwane i odświeżane po zmianie (Firebase listener) przez co lista jest dynamiczna. Po kliknięciu w konkretny element wyzwolona zostaje intencja, zawierająca dodatkowo serializowany obiekt produkt, która uruchamia szczegółowy widok danego produktu, zawierający dodatkowe informacje o ilości błonnika, cukrów czy kategorii.
- **Kalkulator** 
    - kalkulator umożliwiający obliczenia ładunku glikemicznego posiłku oraz możliwość zapisu posiłku
    - użytkownik ma możliwość wybrania z listy produktów (Spinner) interesującego go produktu, następnie po określeniu wagi (wypełnienie wartości odblokowuje przycisk) może dodać produkt jako składnik posiłku (Ingredient) do listy. Użytkownik może w dowolnym momencie wyczyścić listę składników. Po wypełnieniu listy stosownymi składnikami i naciśnięciu przycisk oblicz, wyliczany jest ładunek glikemiczny posiłku, a następnie jest on wyświetlony w TextView. Po wyliczeniu tej wartość i wypełnieniu wartości "Nazwa dania", użytkownik odblokowuje przycisk Zapisz Danie. Kliknięciu przycisku powoduje zapisanie obiektu Recipe sparsowanego do jsona do SharedPreferences pod przekazanym w nazwie kluczem. Potwierdzenie akcji stanowi dodatkowy Toast informujący o sukcesie. Kliknięcia guzika Zapisz powoduje również wyczyszczenie list i pól formularza
- **Przepisy**
    - lista przepisów zapisanych przez użytkownika po użyciu kalkulatora
    - implementacja ListView, który reprezentuje rozparsowane do obiektów dane z SharedPreferences. Po wybraniu konkretnego przepisu użytkownik otrzymuje szczegółowe informacje o nim - listę składników, indeks glikemiczny.


Licencja
----

Copyright AW & JG & ND © 2020 

