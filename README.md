# Web-App-Servlet
Acest proiect reprezintă o aplicație web pentru gestionarea unei agenții de turism, realizată în **Java Servlet + JSP** și gestionată cu **Maven**.   Scopul aplicației este de a oferi o platformă pentru administrarea clienților, destinațiilor și contractelor, cu funcționalități de căutare, raportare și generare documente.  
🔧 Funcționalități principale  
- 👥 **Gestionare clienți**: adăugare, modificare, ștergere, căutare.  
- 🏖️ **Gestionare destinații turistice**: administrare oferte (CRUD).  
- 📑 **Gestionare contracte**: creare și vizualizare contracte.  
- 📊 **Rapoarte și statistici**:   
  - generare rapoarte PDF;    
  - afișare grafice dinamice (ex. contracte pe destinații).  
- 🔐 **Autentificare utilizatori** (login/logout).  
- 🎨 **Interfață web** cu pagini JSP și CSS.  

---

## 📂 Structura proiectului  
- `src/main/java/...` → Servlet-uri și logica de business (controller + DAO)   
- `src/main/webapp/WEB-INF/jsp/` → pagini JSP pentru interfață    
- `src/main/webapp/resources/css/` → stiluri CSS    
- `src/main/webapp/resources/js/` → scripturi JavaScript    
- `pom.xml` → gestionarea dependențelor cu Maven

  🛠️ Tehnologii utilizate  
Backend: Java Servlet, JSP, JDBC  
Frontend: JSP, HTML, CSS, JavaScript  
Bază de date: MySQL  
Build tool: Maven (pom.xml)  
Server: Apache Tomcat  
Biblioteci externe: JSTL, FPDF/itext pentru PDF, Chart.js pentru grafice

Exemple de utilizare  
🔎 Căutarea unui client după nume  
🏖️ Afișarea ofertelor pentru o destinație  
📑 Generare contract în format PDF  
📈 Raport grafic cu numărul de contracte

