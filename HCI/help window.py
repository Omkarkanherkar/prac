import tkinter as tk
from tkinter import messagebox

# Function to show FAQs
def show_faq():
    messagebox.showinfo("FAQs", 
                        "1. How do I register?\n"
                        "Answer: Go to the registration tab and fill in your details.\n\n"
                        "2. How do I reset my password?\n"
                        "Answer: Click on 'Forgot Password' on the login screen and follow the instructions.\n\n"
                        "3. How can I contact support?\n"
                        "Answer: Use the contact information provided at the bottom of this Help screen.")

# Function to contact support
def contact_support():
    messagebox.showinfo("Contact Support", 
                        "You can reach our support team at:\n"
                        "Email: support@app.com\nPhone: +1-800-555-1234")

# Create main window
root = tk.Tk()
root.title("Help")
root.geometry("500x400")

# Title Label
title_label = tk.Label(root, text="App Help & Support", font=("Helvetica", 16))
title_label.pack(pady=10)

# Section: How to Use the App
how_to_use_label = tk.Label(root, text="How to Use the App:", font=("Helvetica", 12))
how_to_use_label.pack(anchor='w', padx=20, pady=5)

how_to_use_text = tk.Label(root, text="1. Login with your credentials.\n"
                                      "2. Navigate through the tabs to access different features.\n"
                                      "3. Use the 'Settings' menu to configure preferences.\n"
                                      "4. For further assistance, visit the 'Help' section.", justify="left")
how_to_use_text.pack(anchor='w', padx=20)

# Section: FAQs
faq_label = tk.Label(root, text="Frequently Asked Questions (FAQs):", font=("Helvetica", 12))
faq_label.pack(anchor='w', padx=20, pady=5)

faq_btn = tk.Button(root, text="Show FAQs", command=show_faq)
faq_btn.pack(anchor='w', padx=20)

# Section: Contact Support
contact_label = tk.Label(root, text="Need more help? Contact Support:", font=("Helvetica", 12))
contact_label.pack(anchor='w', padx=20, pady=5)

contact_btn = tk.Button(root, text="Contact Support", command=contact_support)
contact_btn.pack(anchor='w', padx=20, pady=10)

# Footer Section
footer_label = tk.Label(root, text="Thank you for using our App! We're here to help.", font=("Helvetica", 10), fg="gray")
footer_label.pack(side="bottom", pady=20)

# Run the application
root.mainloop()
