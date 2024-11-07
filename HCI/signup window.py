import tkinter as tk
from tkinter import messagebox

# Create the main application window
root = tk.Tk()
root.title("Sign-Up Form")
root.geometry("400x500")
root.configure(bg="Light Blue")

# Function to handle the sign-up button click
def signup():
    name = entry_name.get()
    email = entry_email.get()
    password = entry_password.get()
    confirm_password = entry_confirm_password.get()
    gender = gender_var.get()
    
    # Check if all fields are filled and password matches
    if not name or not email or not password or not confirm_password:
        messagebox.showwarning("Input Error", "Please fill all the fields!")
    elif password != confirm_password:
        messagebox.showwarning("Password Error", "Passwords do not match!")
    else:
        messagebox.showinfo("Success", f"Welcome {name}! Your account has been created.")
        
# Heading label
heading_label = tk.Label(root, text="Sign Up", font=("Arial", 20), bg="Light Blue")
heading_label.pack(pady=20)

# Name label and entry
label_name = tk.Label(root, text="Name:", bg="Light Blue", font=("Arial", 12))
label_name.place(x=30, y=80)
entry_name = tk.Entry(root, width=30)
entry_name.place(x=180, y=80)

# Email label and entry
label_email = tk.Label(root, text="Email:", bg="Light Blue", font=("Arial", 12))
label_email.place(x=30, y=130)
entry_email = tk.Entry(root, width=30)
entry_email.place(x=180, y=130)

# Password label and entry
label_password = tk.Label(root, text="Password:", bg="Light Blue", font=("Arial", 12))
label_password.place(x=30, y=180)
entry_password = tk.Entry(root, width=30, show='*')
entry_password.place(x=180, y=180)

# Confirm Password label and entry
label_confirm_password = tk.Label(root, text="Confirm Password:", bg="Light Blue", font=("Arial", 12))
label_confirm_password.place(x=30, y=230)
entry_confirm_password = tk.Entry(root, width=30, show='*')
entry_confirm_password.place(x=180, y=230)

# Gender label and radio buttons
label_gender = tk.Label(root, text="Gender:", bg="Light Blue", font=("Arial", 12))
label_gender.place(x=30, y=280)

gender_var = tk.StringVar()
radio_male = tk.Radiobutton(root, text="Male", variable=gender_var, value="Male", bg="Light Blue")
radio_female = tk.Radiobutton(root, text="Female", variable=gender_var, value="Female", bg="Light Blue")

radio_male.place(x=150, y=280)
radio_female.place(x=250, y=280)

# Sign Up button
signup_button = tk.Button(root, text="Sign Up", command=signup, width=15, bg="Dark Blue", fg="white", font=("Arial", 12))
signup_button.pack(pady=40)
signup_button.place(x=180,y=320)

# Start the Tkinter event loop
root.mainloop()
