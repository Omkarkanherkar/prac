import tkinter as tk
from tkinter import messagebox

# Function to handle form submission
def submit_form():
    name = name_entry.get()
    age = age_entry.get()
    gender = gender_var.get()
    conditions = []
    if diabetes_var.get() == 1:
        conditions.append("Diabetes")
    if hypertension_var.get() == 1:
        conditions.append("Hypertension")
    if asthma_var.get() == 1:
        conditions.append("Asthma")
    
    department = dept_listbox.get(tk.ACTIVE)

    # Validation
    if not name or not age or not gender or not department:
        messagebox.showwarning("Input Error", "All fields are required!")
        return
    
    try:
        age = int(age)
        if age <= 0:
            raise ValueError
    except ValueError:
        messagebox.showwarning("Input Error", "Please enter a valid age!")
        return

    # Show the collected information
    messagebox.showinfo("Registration Successful", 
                        f"Patient Name: {name}\nAge: {age}\nGender: {gender}\n"
                        f"Medical Conditions: {', '.join(conditions) if conditions else 'None'}\n"
                        f"Department: {department}")

# Create main window
root = tk.Tk()
root.title("Patient Registration Form")
root.geometry("500x700")

# Title Label
title_label = tk.Label(root, text="Hospital Patient Registration Form", font=("Helvetica", 16))
title_label.pack(pady=10)

# Name Label and Entry
name_label = tk.Label(root, text="Full Name:")
name_label.pack(pady=5)

name_entry = tk.Entry(root, width=40)
name_entry.pack(pady=5)

# Age Label and Entry
age_label = tk.Label(root, text="Age:")
age_label.pack(pady=5)

age_entry = tk.Entry(root, width=40)
age_entry.pack(pady=5)

# Gender Label and Radio Buttons
gender_label = tk.Label(root, text="Gender:")
gender_label.pack(pady=5)

gender_var = tk.StringVar()  # Correct variable for gender selection
gender_var.set(None)  # Initialize with no selection

male_rb = tk.Radiobutton(root, text="Male", variable=gender_var, value="Male")
male_rb.pack()
female_rb = tk.Radiobutton(root, text="Female", variable=gender_var, value="Female")
female_rb.pack()
other_rb = tk.Radiobutton(root, text="Other", variable=gender_var, value="Other")
other_rb.pack()

# Medical Conditions (Checkbuttons)
conditions_label = tk.Label(root, text="Medical Conditions (if any):")
conditions_label.pack(pady=5)

diabetes_var = tk.IntVar()
diabetes_cb = tk.Checkbutton(root, text="Diabetes", variable=diabetes_var)
diabetes_cb.pack()

hypertension_var = tk.IntVar()
hypertension_cb = tk.Checkbutton(root, text="Hypertension", variable=hypertension_var)
hypertension_cb.pack()

asthma_var = tk.IntVar()
asthma_cb = tk.Checkbutton(root, text="Asthma", variable=asthma_var)
asthma_cb.pack()

# Department Label and Listbox
dept_label = tk.Label(root, text="Select Department:")
dept_label.pack(pady=5)

dept_listbox = tk.Listbox(root, height=5)
departments = ["Cardiology", "Neurology", "Orthopedics", "Pediatrics", "General Medicine"]
for dept in departments:
    dept_listbox.insert(tk.END, dept)
dept_listbox.pack(pady=5)

# Submit Button
submit_btn = tk.Button(root, text="Submit", command=submit_form)
submit_btn.pack(pady=20)

# Run the application
root.mainloop()
