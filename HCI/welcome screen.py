import tkinter as tk

# Function to proceed to the next screen (you can modify this as needed)
def proceed():
    print("Proceeding to the main application...")  # Placeholder for your next screen logic
    root.destroy()  # Close the welcome screen (optional)

def exit():
    print("Proceeding to the exit application...")  # Placeholder for your next screen logic
    root.destroy()

# Create the main window
root = tk.Tk()
root.title("Welcome Screen")
root.geometry("400x300")  # Set the size of the window

# Title Label
title_label = tk.Label(root, text="Welcome to Our Application", font=("Helvetica", 18, "bold"))
title_label.pack(pady=20)

# Subtitle Label
subtitle_label = tk.Label(root, text="Your gateway to amazing features", font=("Helvetica", 12))
subtitle_label.pack(pady=10)

# Proceed Button
proceed_button = tk.Button(root, text="Get Started", command=proceed, font=("Helvetica", 14))
proceed_button.pack(pady=30)

exit_button = tk.Button(root, text="Exit", command=exit, font=("Helvetica", 14))
exit_button.pack(pady=30)

# Run the application
root.mainloop()
