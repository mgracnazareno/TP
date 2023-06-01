package TP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mgrac
 */
public class CalendrierReservations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Department dept = new Department();
        String res = "";

        ArrayList<Local> local = new ArrayList<Local>();
        Local local1 = new FormationContinue(430, 4, 10, 15, 2);
        Local local2 = new FormationReguliere(330, 3, 7, 21, "Hiver", new Department("Informatique"));
        Local local3 = new FormationReguliere(130, 1, 9, 11, "Ete", new Department("Sciences Nature"));
        Local local4 = new FormationContinue(135, 1, 18, 12, 1);
        Local local5 = new FormationContinue(223, 2, 19, 22, 3);
        Local local6 = new FormationReguliere(210, 2, 9, 11, "Automne", new Department("Sciences Humaine"));
        Local local7 = new FormationReguliere(410, 4, 18, 23, "Hiver", new Department("Informatique"));
        Local local8 = new FormationReguliere(300, 3, 14, 16, "Ete", new Department("Sciences Nature"));
        Local local9 = new FormationContinue(110, 1, 19, 20, 3);
        Local local10 = new FormationReguliere(305, 3, 15, 17, "Ete", new Department("Informatique"));

        //valider tous les locaux reserver en appelant  la methode reserver)
        local1.reserver(10, 15);
        local2.reserver(7, 21);
        local3.reserver(9, 11);
        local4.reserver(18, 12);
        local5.reserver(19, 22);
        local6.reserver(9, 11);
        local7.reserver(16, 18);
        local8.reserver(14, 16);
        local9.reserver(19, 20);
        local10.reserver(15, 17);

        local.add(local1);
        local.add(local2);
        local.add(local3);
        local.add(local4);
        local.add(local5);
        local.add(local6);
        local.add(local7);
        local.add(local8);
        local.add(local9);
        local.add(local10);

        do {
            menu();
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                sc.next();
            }
            int choix = sc.nextInt();

            switch (choix) {
                case 1:
                    horaire();
                    break;

                case 2:
                    afficherLocaux(local);

                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Entrez le nombre de locaux à vérifier : ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Veuillez entrer un nombre valide !");
                            scanner.next();
                        }
                        int numLocaux = scanner.nextInt();

                        for (int i = 1; i <= numLocaux; i++) {
                            System.out.print("Entrez le numero local a verifer: ");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Veuillez entrer un nombre valide !");
                                    scanner.next();
                                }
                            int numLocal = scanner.nextInt();
                            testReservation(local, numLocal);
                        }
                    break;
                case 4:
                    afficherLocalParHeure(local);
                    break;
                case 5:
                    compterLocauxReserves(local);
                    break;
                case 6:
                    System.out.println("Quitting...Merci!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, essayez de nouveau.");
                    break;
            }
            System.out.println("Voulez-vous tester autres methods?: ");
            res = sc.next();
            sc.nextLine();

        } while (res.equalsIgnoreCase("oui") || res.equalsIgnoreCase("o"));

    }

    //cette fonction affiche le menu afin que l'utilisateur puisse 
    //choisir quelle fonction tester
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Voyez le crenea des horaires reservation ");
        System.out.println("2. Afficher la liste de tous le locaux");
        System.out.println("3. Tester la methode testReservation()");
        System.out.println("4. Afficher des locaux reserve heure par heure");
        System.out.println("5. Afficher les statistiques de reservation");
        System.out.println("6. Quiter");
        System.out.println("Entrez votre choix: ");
    }

    //affiche l'heure à laquelle l'utilisateur peut effectuer la réservation
    public static void horaire() {
        System.out.println("------- Horaires des reservations -------");
        System.out.println("Formation Reguliere: ");
        System.out.println("Department:\n\tLes Sciences:  8h - 18h");
        System.out.println("\tInformatique: 15h - 18h");
        System.out.println("Formation Continue:   18h - 23h");
        System.out.println("Tous les locaux doivent etre libres entre 12h et 13h\n\n");
    }

    //affiche la liste de tous les locaux
    public static void afficherLocaux(ArrayList<Local> listLocal) {
        for (int i = 0; i < listLocal.size(); i++) {
            System.out.println("************************");
            System.out.println(listLocal.get(i).toString());
        }
        System.out.println("**************************");
    }

    //permet tester si un local est reserve ou non
    public static void testReservation(ArrayList<Local> listLocal, int numeroLocal) {
        boolean localExiste = false;
        int counter = 0;

        
        for (Local local : listLocal) {
            if (local.getNumero() == numeroLocal) {
                localExiste = true;
                
                
               //counter++;
                if (local.reserver(local.getHeureDebut(), local.getHeureFin())) {
                    System.out.println("**" + (counter + 1) + " Test avec le local numéro " + numeroLocal + "**");
                    System.out.println("Ce local est deja reserve de " + local.getHeureDebut() + " à " + local.getHeureFin());
                } else {
                    System.out.println("**" + listLocal.get(counter) + "ème Test avec le local numéro " + numeroLocal + "**");
                    System.out.println("Ce local est libre");
                }

                //break;
               // counter++;
            }

            //counter++;
        }
        
        
        if (!localExiste) {
            System.out.println("Ce local n'existe pas dans la liste");
        }
    }

    //afficher heure par heure tous les locaux reserves
    public static void afficherLocalParHeure(ArrayList<Local> listLocal) {
        System.out.println("******* Affichage Heure Par Heure ********");
        for (Local local : listLocal) {
            if (local.reservation) {
                System.out.println(local.getHeureDebut() + "h: Local " + local.getEtage() + "-" + local.getNumero());
            }
        }
    }

    //affiche la statistiques  de reservation
    public static void compterLocauxReserves(ArrayList<Local> listLocal) {
        int totalReserve = 0;
        int totalFContinue = 0;
        int totalFReguliere = 0;
        int compterInformatique = 0;
        int compterSciencesHumaines = 0;
        int compterSciencesNature = 0;

        for (Local local : listLocal) {
            if (local.reservation) {
                totalReserve++;
                if (local instanceof FormationContinue fc) {
                    totalFContinue++;
                } else if (local instanceof FormationReguliere fr) {
                    totalFReguliere++;
                    String department = ((FormationReguliere) local).dept.getNom();
                    switch (department) {
                        case "Informatique":
                            compterInformatique++;
                            break;
                        case "Sciences Humaine":
                            compterSciencesHumaines++;
                            break;
                        case "Sciences Nature":
                            compterSciencesNature++;
                            break;
                        default:
                            System.out.println("Invalide, n'existe pas");
                            break;
                    }
                }
            }
        }
        System.out.println("**********Statistiques Reservations**********");
        System.out.println("Il y a " + totalReserve + " locaux réservés au total:");
        System.out.println("\t" + totalFContinue + " " + " Formation Continue");
        System.out.println("\t" + totalFReguliere + " " + " Formation Reguliere");
        System.out.println("\t\t" + compterInformatique + " Informatique");
        System.out.println("\t\t" + compterSciencesHumaines + " Sciences Humaines");
        System.out.println("\t\t" + compterSciencesNature + " Sciences Nature");
    }
}
