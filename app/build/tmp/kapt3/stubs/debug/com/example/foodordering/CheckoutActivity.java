package com.example.foodordering;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/foodordering/CheckoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/razorpay/PaymentResultListener;", "()V", "binding", "Lcom/example/foodordering/databinding/ActivityCheckoutBinding;", "razorpayKeyId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPaymentError", "code", "", "response", "onPaymentSuccess", "razorpayPaymentId", "showConfirmationDialog", "showToast", "message", "startPayment", "amount", "", "app_debug"})
public final class CheckoutActivity extends androidx.appcompat.app.AppCompatActivity implements com.razorpay.PaymentResultListener {
    private com.example.foodordering.databinding.ActivityCheckoutBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String razorpayKeyId = "rzp_test_SeexT7isLxMrg5";
    
    public CheckoutActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void startPayment(double amount) {
    }
    
    @java.lang.Override()
    public void onPaymentSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.String razorpayPaymentId) {
    }
    
    @java.lang.Override()
    public void onPaymentError(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String response) {
    }
    
    private final void showConfirmationDialog() {
    }
    
    private final void showToast(java.lang.String message) {
    }
}