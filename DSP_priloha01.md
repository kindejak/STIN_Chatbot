# DSP (Dokument specifikace požadavků) - příloha č. 01

## Úvod
Cílem této přílohy je dopnit k DSP požadavky, na základě nových požadavků od zadavatele projektu.

## Rozšíření požadavků

Následující požadavky jsou rozšíření požadavků zadavatele:

| Požadavek | Klíčové slovo/klíčová slova | Odpověď serveru | Poznámka |
| --- | --- | --- | --- |
| doporučení nákupu EUR | exchange tips, exchange recommendation | In my honest opinion it's great time to exchange money, because between $date1 and $date2  exchange rate changed by $change % (my threshold is set to 10%)/Sorry, I think you shouldn't exchange money because between $date1 and $date2  exchange rate changed by $change % (my threshold is set to 10%) | mezi dny je prostor tři dny, pokud mezi nimi není víkend, jinak je prostor větší $date1 -> počátek období, $date2 -> konec období, $change -> změna kurzu v procentech |


## Úprava požadavků
| Požadavek | Klíčové slovo/klíčová slova | Odpověď serveru | Poznámka |
| --- | --- | --- | --- |
| vypsání nápovědy | help | Here is what I can do: <br>-help - I tell you, what I can do <br>-time - I tel you, what time is it, at least at my place.<br>-exchange rate - I tell you an exchange rate between EUR and CZK <br>-name - I tell you my name<br>-recommendation - I'll (not) recommend you exchanging money between two currencies | rozšíření o poslední položku na seznamu nápovědy (recommendation) |