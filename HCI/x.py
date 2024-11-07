import tkinter as tk
from tkinter import messagebox, StringVar, OptionMenu

# Function to handle the booking
def book_ride():
    name = name_entry.get()
    pickup_location = pickup_entry.get()
    dropoff_location = dropoff_entry.get()
    vehicle_type = vehicle_var.get()

    # Basic input validation
    if not name or not pickup_location or not dropoff_location or not vehicle_type:
        messagebox.showwarning("Input Error", "All fields are required!")
        return

    messagebox.showinfo("Booking Confirmed", f"Booking Confirmed!\n"
                                             f"Name: {name}\n"
                                             f"Pickup: {pickup_location}\n"
                                             f"Drop-off: {dropoff_location}\n"
                                             f"Vehicle Type: {vehicle_type}")

# Create the main window
root = tk.Tk()
root.title("Cab/Auto Booking App")
root.geometry("400x400")

# Title Label
title_label = tk.Label(root, text="Cab/Auto Booking", font=("Helvetica", 18, "bold"))
title_label.pack(pady=10)

# Name Label and Entry
name_label = tk.Label(root, text="Name:")
name_label.pack(pady=5)
name_entry = tk.Entry(root, width=30)
name_entry.pack(pady=5)

# Pickup Location Label and Entry
pickup_label = tk.Label(root, text="Pickup Location:")
pickup_label.pack(pady=5)
pickup_entry = tk.Entry(root, width=30)
pickup_entry.pack(pady=5)

# Drop-off Location Label and Entry
dropoff_label = tk.Label(root, text="Drop-off Location:")
dropoff_label.pack(pady=5)
dropoff_entry = tk.Entry(root, width=30)
dropoff_entry.pack(pady=5)

# Vehicle Type Label and Dropdown
vehicle_label = tk.Label(root, text="Select Vehicle Type:")
vehicle_label.pack(pady=5)
vehicle_var = StringVar()
vehicle_options = ["Economy", "Standard", "Luxury", "Auto Rickshaw"]
vehicle_dropdown = OptionMenu(root, vehicle_var, *vehicle_options)
vehicle_dropdown.config(width=28)  # Set the width of the dropdown
vehicle_dropdown.pack(pady=5)

# Book Button
book_button = tk.Button(root, text="Book Ride", command=book_ride)
book_button.pack(pady=20)

# Run the application
root.mainloop()
