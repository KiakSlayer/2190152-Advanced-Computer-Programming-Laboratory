
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class SimpleTransactionManager implements TransactionManager {
    private String[] wallets = new String[1000];
    private String[] transactions = new String[10000];    
    private int walletCount;
    private int transactionCount = 0;

    public SimpleTransactionManager(String[] initialWallets) {
        for (int i = 0; i < initialWallets.length; i++) {
            this.wallets[i] = initialWallets[i];
            walletCount++;
        } 
    }

    @Override
    public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) throws InvalidTransactionException {
        if(!isValidWallet(senderWalletId)) 
            throw new IllegalArgumentException("Sender wallet does not exist.");
        if(getBalance(senderWalletId) < amount && !senderWalletId.equals(wallets[0]))
            throw new InvalidTransactionException("Not enough balance in the source wallet.");
        if (!isValidWallet(receiverWalletId)) {
            wallets[walletCount] = receiverWalletId;
            walletCount++;
        }
        String transacFormat = senderWalletId + "|" + receiverWalletId + "|" + amount;
        transactions[transactionCount] = transacFormat; 
        transactionCount++;
        return true;
    }

    @Override
    public double getBalance(String walletId) {
        if (!isValidWallet(walletId)) {
            throw new IllegalArgumentException("Invalid wallet ID.");
        }
        double balance = 0.0;
        for (int i = 0; i <transactionCount; i++) {
            String[] parts = transactions[i].split("\\|");
            if (parts[0].equals(walletId)) {
                balance -= Double.parseDouble(parts[2]);
            }
            if (parts[1].equals(walletId)) {
                balance += Double.parseDouble(parts[2]);
            }
        }
        return balance;
    }

    @Override
    public boolean isValidWallet(String walletId) {
        for(int i = 0; i < wallets.length; i++) {
            if(wallets[i]!= null && wallets[i].equals(walletId)) return true;
        }
        return false;
    }
}
