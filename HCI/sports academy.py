import tkinter as tk
from tkinter import messagebox, StringVar

# Function to handle the registration
def register():
    name = name_entry.get()
    age = age_entry.get()
    gender = gender_var.get()
    sport = sport_var.get()

    # Basic input validation
    if not name or not age or not gender or not sport:
        messagebox.showwarning("Input Error", "All fields are required!")
        return

    try:
        age = int(age)
        if age <= 0:
            raise ValueError
    except ValueError:
        messagebox.showwarning("Input Error", "Enter a valid age!")
        return

    messagebox.showinfo("Registration Successful", f"Registered {name} for {sport}.")

# Create the main window
root = tk.Tk()
root.title("Sports Academy Registration Form")
root.geometry("400x400")

# Title Label
title_label = tk.Label(root, text="Sports Academy Registration", font=("Helvetica", 18, "bold"))
title_label.pack(pady=10)

# Name Label and Entry
name_label = tk.Label(root, text="Name:")
name_label.pack(pady=5)
name_entry = tk.Entry(root, width=30)
name_entry.pack(pady=5)

# Age Label and Entry
age_label = tk.Label(root, text="Age:")
age_label.pack(pady=5)
age_entry = tk.Entry(root, width=30)
age_entry.pack(pady=5)

# Gender Label and Radiobuttons
gender_label = tk.Label(root, text="Gender:")
gender_label.pack(pady=5)

# Initialize StringVar without a default value
gender_var = StringVar(value="")  # Initialize with an empty string

# Create a frame for gender radiobuttons
gender_frame = tk.Frame(root)
gender_frame.pack(pady=5)

# Create Radiobuttons
male_rb = tk.Radiobutton(gender_frame, text="Male", variable=gender_var, value="Male")
female_rb = tk.Radiobutton(gender_frame, text="Female", variable=gender_var, value="Female")

# Pack Radiobuttons
male_rb.pack(side=tk.LEFT)
female_rb.pack(side=tk.LEFT)

# Sport Label and Dropdown
sport_label = tk.Label(root, text="Select Sport:")
sport_label.pack(pady=5)
sport_var = StringVar()
sport_options = ["Cricket", "Football", "Basketball", "Tennis", "Swimming"]

# Create OptionMenu with a dropdown arrow
sport_dropdown = tk.OptionMenu(root, sport_var, *sport_options)
sport_dropdown.config(width=28)  # Set the width of the dropdown
sport_dropdown.pack(pady=5)

# Submit Button
submit_button = tk.Button(root, text="Register", command=register)
submit_button.pack(pady=20)

# Run the application
root.mainloop()
