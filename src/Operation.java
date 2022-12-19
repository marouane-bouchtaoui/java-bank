import java.util.Scanner;

public class Operation implements CreateMenu{
    String nom;
    String client_id;
    Double Solde;
    Double operationPrec;

    public Operation(String cname,String c_id){
        this.nom = cname;
        this.client_id = c_id;
    }

    public void virement(Double montant){
        if (montant != 0){
            this.Solde = this.Solde + montant;
            this.operationPrec = montant;
        }
    }

    public void retrait(Double montant){
        if (montant != 0){
            this.Solde = this.Solde - montant;
            this.operationPrec = -montant;
        }
    }

    public void operationPrecedente(){
        if (this.operationPrec > 0){
            System.out.println("Virement de montant :" + this.operationPrec);
        } else if (this.operationPrec < 0){
            System.out.println("Retrait de montant :" + Math.abs(this.operationPrec));
        } else {
            System.out.println("Aucune opération");
        }
    }

    public void showMenu(){
        char option = 'o';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome : " + this.nom);
        System.out.println("Votre id : " + this.client_id);
        System.out.println("\n");
        System.out.println("A- Consulter votre solde");
        System.out.println("B- Virement");
        System.out.println("C- Retrait");
        System.out.println("D- Opération precédente");
        System.out.println("E- Sortir");

        do {
            System.out.println("---------------------------------------");
            System.out.println("Veuillez choisir une option");
            System.out.println("---------------------------------------");
            option = scanner.next().charAt(0);
            switch (option){
                case 'A' :
                    System.out.println("---------------------------------------");
                    System.out.println("Votre solde est : " + this.Solde);
                    System.out.println("---------------------------------------");
                break;
                case 'B' :
                    System.out.println("---------------------------------------");
                    System.out.println("Entrez le montant : ");
                    Double montant = scanner.nextDouble();
                    virement(montant);
                    System.out.println("\n");
                break;
                case 'C' :
                    System.out.println("---------------------------------------");
                    System.out.println("Entrez le montant : ");
                    Double amount = scanner.nextDouble();
                    retrait(amount);
                    System.out.println("\n");
                break;
                case 'D' :
                    System.out.println("---------------------------------------");
                    operationPrecedente();
                    System.out.println("---------------------------------------");
                    System.out.println("\n");
                break;
                case 'E' :
                    System.out.println("---------------------------------------");
                break;
                default:
                    System.out.println("Opération invalide");
                break;
            }
        }while (option != 'E');
        System.out.println("Merci pour votre visite");
        scanner.close();
    }
}
