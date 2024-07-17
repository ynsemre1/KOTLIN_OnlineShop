# Online Shop Application

This is a Kotlin-based Online Shop application consisting of three primary screens. The app leverages Firebase for backend services and follows the MVVM architectural pattern. Below are the details of the application, its features, and instructions on how to set it up.

## Screenshots

### Main Screen
<img width="355" alt="MainActivity" src="https://github.com/user-attachments/assets/4e7dfd09-13d7-49eb-bb0f-0967980428af">

### Product Detail Screen
<img width="362" alt="DetailActivity" src="https://github.com/user-attachments/assets/711acc75-e33a-4b41-80c3-7baadca8fcdd">


### Cart Screen
<img width="362" alt="CartActivity" src="https://github.com/user-attachments/assets/d5e8bb74-3e11-4f47-ac7a-672e4293f725">


## Features

- **Main Screen**: Displays a collection of products and categories.
- **Product Detail Screen**: Shows detailed information about a selected product.
- **Cart Screen**: Allows users to view and manage items in their shopping cart.

## Technologies Used

- **Kotlin**: The primary programming language used for the development of the application.
- **Firebase**: Used for backend services including authentication, real-time database, and storage.
- **MVVM (Model-View-ViewModel)**: Architectural pattern used to separate concerns and manage UI-related data.
- **Observer Pattern**: Used for handling data updates and ensuring the UI reflects the current state.

## Application Structure

### Main Screen

The main screen of the application shows a collection of products and categories. Users can browse through different products and select one to view its details.

### Product Detail Screen

On the product detail screen, users can see detailed information about the selected product, including price, description, and available sizes.

### Cart Screen

The cart screen allows users to view the items they have added to their cart. Users can modify the quantity of each item or remove items from the cart.

## Working Features

- **Research Tab**: Allows users to search for products.
- **Cart Tab**: Shows the items added to the cart.

## Non-functional Features

- **Liked Items**: This feature is not yet implemented.
- **Order History**: This feature is not yet implemented.
- **Profile Management**: This feature is not yet implemented.

## Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Open the Project in Android Studio**:
    - Ensure you have the latest version of Android Studio installed.
    - Open the project directory in Android Studio.

3. **Configure Firebase**:
    - Add your Firebase project configuration file (`google-services.json`) to the `app` directory.
    - Ensure Firebase services are correctly set up in your Firebase console.

4. **Build and Run**:
    - Build the project in Android Studio.
    - Run the application on an emulator or physical device.

## Project Video

For a step-by-step guide on how this project was built, refer to [this YouTube video](https://www.youtube.com/watch?v=jh1GXnFw7rM&t=428s).
