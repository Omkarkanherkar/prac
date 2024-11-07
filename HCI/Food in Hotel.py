import tkinter as tk
from tkinter import messagebox

# Create the main application window
root = tk.Tk()
root.title("Customer Feedback Form")
root.geometry("400x500")
root.configure(bg="Light Green")

# Function to submit feedback
def submit_feedback():
    name = entry_name.get()
    rating = rating_var.get()
    
    # Collect selected experiences
    experience = ", ".join([exp.get() for exp in experience_vars if exp.get()])
    
    if not name or not rating or not experience:
        messagebox.showwarning("Incomplete", "Please fill all fields!")
    else:
        messagebox.showinfo("Feedback Received", f"Thank you {name} for your feedback!\n\nRating: {rating}\nExperience: {experience}")

# Heading label
heading_label = tk.Label(root, text="Customer Feedback Form", font=("Arial", 18), bg="Light Green")
heading_label.pack(pady=20)

# Name label and entry
label_name = tk.Label(root, text="Name:", bg="Light Green", font=("Arial", 12))
label_name.place(x=30, y=80)
entry_name = tk.Entry(root, width=30)
entry_name.place(x=150, y=80)

# Rating label
label_rating = tk.Label(root, text="Rate Us", bg="Light Green", font=("Arial", 12))
label_rating.place(x=30, y=130)

# Rating variable and radio buttons
rating_var = tk.IntVar()
rating_var.set(0)

radio_1 = tk.Radiobutton(root, text="1", variable=rating_var, value=1, bg="Light Green")
radio_2 = tk.Radiobutton(root, text="2", variable=rating_var, value=2, bg="Light Green")
radio_3 = tk.Radiobutton(root, text="3", variable=rating_var, value=3, bg="Light Green")
radio_4 = tk.Radiobutton(root, text="4", variable=rating_var, value=4, bg="Light Green")
radio_5 = tk.Radiobutton(root, text="5", variable=rating_var, value=5, bg="Light Green")

# Arrange the radio buttons
radio_1.place(x=150, y=130)
radio_2.place(x=180, y=130)
radio_3.place(x=210, y=130)
radio_4.place(x=240, y=130)
radio_5.place(x=270, y=130)

# Experience label
label_experience = tk.Label(root, text="Your Experience:", bg="Light Green", font=("Arial", 12))
label_experience.place(x=30, y=180)

# Experience checkbuttons
experience_vars = []
experiences = ["Good Service", "Tasty Food", "Hygienic", "Fast Service", "Friendly Staff"]

for i, exp in enumerate(experiences):
    var = tk.StringVar()
    checkbutton = tk.Checkbutton(root, text=exp, variable=var, onvalue=exp, offvalue="", bg="Light Green")
    checkbutton.place(x=150, y=210 + i*30)
    experience_vars.append(var)

# Submit button
submit_button = tk.Button(root, text="Submit Feedback", command=submit_feedback, width=20, bg="Dark Green", fg="white", font=("Arial", 12))
submit_button.pack(pady=40)
submit_button.place(x= 130,y= 370)

# Start the Tkinter event loop
root.mainloop()
