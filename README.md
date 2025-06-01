<h1>Vitale Andrea - MyRestApp</h1>

## Funzionalità del Progetto
MyRestApp è un'applicazione Android distribuita che permette, attraverso un'interfaccia intuitiva basata sull'uso di alcuni bottoni, di ricercare film attraverso un API integrata, e accedere ad un browser web.
L'app integra anche un sistema di login con credenziali memorizzate all'interno del progetto.


## Le activity

### 1. MainActivity
Activiti principale che contiene funzioni di login, le credenziali funzionanti sono:
- User1/123
- User2/456
- User3/789
<br>
Inserita una coppia di credenziali corretta sarà possibile accedere al menù, attraverso un intent a MenuActivity. <br>
La funzione di accesso login(): <br>
Ha come parametri i campi testuali Nome Utente e Password, che recupera sotto forma di stringa, li confronta con i valori contenuti negli array, controlla che essi siano stati compilati e che la password sia lunga almeno 3 caratteri.
In base alla correttezza delle credenziali inserite sarà garantito o meno l'accesso atraverso dei toast dedicati.

```kotlin
    private fun login(users: Array<String>, pwds: Array<String>) {

        // Acquisice valori compilati nei campi utente e password
        var user = findViewById<EditText>(R.id.textUsername)
        var userTXT = user.text.toString()
        var pwd = findViewById<EditText>(R.id.textPassword)
        var pwdTXT = pwd.text.toString()



        // Controlla che i campi utente e password siano compilati
        if (userTXT.isEmpty() || pwdTXT.isEmpty()) {
            Toast.makeText(this, getString(R.string.controllo_compilazione), Toast.LENGTH_SHORT).show()
            return
        }

        // Controlla che la password sia lunga almeno 3 caratteri
        if (pwdTXT.length < 3) {
            Toast.makeText(this, getString(R.string.criterio_password), Toast.LENGTH_SHORT).show()
            return
        }



        // Scorre array users e controlla se quelli inseriti corrispondo a quelli registrati nell'array (usa lo stesso indice per users e pwds)
        for(i in users.indices){
            if(users[i].contentEquals(userTXT) && pwds[i].contentEquals(pwdTXT)){
                val intent = Intent(this, menu_activity::class.java)
                var toast = Toast.makeText(this, R.string.acessoConfermato, Toast.LENGTH_LONG)
                toast.show()
                startActivity(intent)
                return
            }
        }
        // Se non trova corrispondenze nega accesso
        var toast = Toast.makeText(this, R.string.accessoErrore, Toast.LENGTH_LONG)
        toast.show()
    }
```


### 2. MenuActivity
Seconda activity a cui si accede se le credenziali inserite sono corrette.
Permette di selezionare fra 3 funzionalità diverse, attraverso dei bottoni associati: ricerca di un film (Search), apertura finestra browser (WebView), e Rest, ancora non implementata.


### 3. SearchActivity con MovieAdapter
Funzionalità che si avvale dell'API OMDb, in base al film inserito nel campo testuale di ricerca, fornisce una lista di risultati possibinili in JSON, visualizzata attraverso una vista specifica che ne permette la consultazione. <br>
Crediti: Francesco Amendola <a href="https://github.com/amendola-scuola/FilmSearch">@amendola-scuola</a>

### 4. RestActivity
Activity ancora da implementare.

