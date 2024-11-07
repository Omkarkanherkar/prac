import tkinter as tk
from tkinter import messagebox

# Function to calculate score
def calculate_score():
    score = 0
    if var1.get() == 3:  # Correct answer for Q1 is option 3 (JavaScript)
        score += 1
    if var2.get() == 2:  # Correct answer for Q2 is option 2 (Paris)
        score += 1
    if var3.get() == 2:  # Correct answer for Q3 is option 2 (10)
        score += 1
    
    messagebox.showinfo("Result", f"Your Score is: {score}/3")

# Create main window
root = tk.Tk()
root.title("Online Quiz")
root.geometry("500x500")

# Label for Quiz Title
title_label = tk.Label(root, text="Online Quiz", font=("Helvetica", 16))
title_label.pack(pady=10)

# Question 1
q1_label = tk.Label(root, text="Q1. Which programming language is used for web development?")
q1_label.pack(pady=5)

var1 = tk.IntVar()  # To store the selected option
var1.set(0)  # Default value

q1_rb1 = tk.Radiobutton(root, text="Python", variable=var1, value=1)
q1_rb1.pack()

q1_rb2 = tk.Radiobutton(root, text="C++", variable=var1, value=2)
q1_rb2.pack()

q1_rb3 = tk.Radiobutton(root, text="JavaScript", variable=var1, value=3)
q1_rb3.pack()

# Question 2
q2_label = tk.Label(root, text="Q2. What is the capital of France?")
q2_label.pack(pady=5)

var2 = tk.IntVar()
var2.set(0)

q2_rb1 = tk.Radiobutton(root, text="Berlin", variable=var2, value=1)
q2_rb1.pack()

q2_rb2 = tk.Radiobutton(root, text="Paris", variable=var2, value=2)
q2_rb2.pack()

q2_rb3 = tk.Radiobutton(root, text="Madrid", variable=var2, value=3)
q2_rb3.pack()

# Question 3
q3_label = tk.Label(root, text="Q3. What is the result of 5 + 5?")
q3_label.pack(pady=5)

var3 = tk.IntVar()
var3.set(0)

q3_rb1 = tk.Radiobutton(root, text="9", variable=var3, value=1)
q3_rb1.pack()

q3_rb2 = tk.Radiobutton(root, text="10", variable=var3, value=2)
q3_rb2.pack()

q3_rb3 = tk.Radiobutton(root, text="11", variable=var3, value=3)
q3_rb3.pack()

# Submit Button
submit_btn = tk.Button(root, text="Submit", command=calculate_score)
submit_btn.pack(pady=20)

# Run the application
root.mainloop()
