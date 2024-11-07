import tkinter as tk
from tkinter import messagebox

# Function to perform the fund transfer
def transfer_funds():
    sender_acc = sender_entry.get()
    receiver_acc = receiver_entry.get()
    amount = amount_entry.get()

    # Basic input validation
    if not sender_acc or not receiver_acc or not amount:
        messagebox.showwarning("Input Error", "All fields are required!")
        return

    try:
        amount = float(amount)
        if amount <= 0:
            raise ValueError
    except ValueError:
        messagebox.showwarning("Input Error", "Enter a valid amount!")
        return

    # Simulate successful transaction
    messagebox.showinfo("Transaction Successful", f"₹{amount} has been transferred from {sender_acc} to {receiver_acc}")

# Create the main window
root = tk.Tk()
root.title("Fund Transfer")
root.geometry("400x300")

# Title Label
title_label = tk.Label(root, text="Fund Transfer", font=("Helvetica", 16))
title_label.pack(pady=10)

# Sender's Account Label and Entry
sender_label = tk.Label(root, text="Sender's Account:")
sender_label.pack(pady=5)

sender_entry = tk.Entry(root, width=30)
sender_entry.pack(pady=5)

# Receiver's Account Label and Entry
receiver_label = tk.Label(root, text="Receiver's Account:")
receiver_label.pack(pady=5)

receiver_entry = tk.Entry(root, width=30)
receiver_entry.pack(pady=5)

# Amount Label and Entry
amount_label = tk.Label(root, text="Amount to Transfer (₹):")
amount_label.pack(pady=5)

amount_entry = tk.Entry(root, width=30)
amount_entry.pack(pady=5)

# Transfer Button
transfer_button = tk.Button(root, text="Transfer", command=transfer_funds)
transfer_button.pack(pady=20)

# Run the application
root.mainloop()
