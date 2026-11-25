// Workshop 1 -- Varianti B (Hyrja me role)
// Programi lexon rolin, kontrollon llogarine dhe shfaq se sa hapesire disku ka perdoruesi

void main() {

    // Printojme rolet qe perdoruesi te zgjedh nga ato
    IO.println("Zgjidhni perdoruesin: ");
    IO.println("1. admin");
    IO.println("2. user");
    IO.println("3. guest");
    IO.println("4. operator");

    // Lexojme rolin si tekst dhe e kthejme ne numer me parseInt
    int roli = Integer.parseInt(IO.readln("Roli (1-4): ").trim());

    int niveli = switch (roli) {
        case 1 -> 3;
        case 2 -> 2;
        case 3 -> 1;
        case 4 -> 2;
        default -> 0;
    };

    // Kontrollojme nivelet e perdoruesve me if, else if dhe else
    if (niveli == 0) {
        IO.println("Rol i panjohur.");
    } else if (niveli == 1) {
        IO.println("Mysafir: vetëm lexim, pa fjalëkalim.");
    } else {
        // Lexojme perdoruesin dhe ja largojme hapesirat dhe e kthejme ne lowercase
        String perdoruesi = IO.readln("Perdoruesi: ").trim().toLowerCase();

        // Lexojme fjalekalimin ashtu si eshte shkruar
        String fjalekalimi = IO.readln("Fjalekalimi: ");

        if (fjalekalimi.length() == 0) {
            IO.println("Fjalekalimi nuk mund te jete bosh");
        } else {
            //        String perdoruesiSakte = niveli == 3 ? "admin" : "arta";
            String perdoruesiSakte = switch (roli) {
                case 1 -> "admin";
                case 2 -> "arta";
                default -> "operator";
            };
//        String fjalekalimiSakte = niveli == 3 ? "S3kret!2026" : "arta2026";
            String fjalekalimiSakte = switch (roli) {
                case 1 -> "S3kret!2026";
                case 2 -> "arta2026";
                default -> "Op3r!2026";
            };


            // Kontrollon se a po e hyjme mire ne llogarine perkatese
            boolean hyri = perdoruesi.equals(perdoruesiSakte) && fjalekalimi.equals(fjalekalimiSakte);

            // Zgjedhim mesazhin ne vend se te kthej true apo false
            IO.println(hyri ? "Hyrje e sukseshme." : "Perdoruesi ose fjalekalimi i gabuar.");

            // LLogarisim hapesiren ne disk
            if (hyri) {
                System.out.printf("Hapesira juaj: %.2f GB%n", niveli * 2.5);
            }
        }
    }

}