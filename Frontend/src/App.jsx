// import './assets/css/login.css'
import { Suspense, lazy } from "react"
import {RouterProvider, createBrowserRouter} from "react-router-dom"
// import Home from "./pages/Home.jsx"
import Spinner from "./components/spinner"
import Login from './pages/Login.jsx'
import Signup from './pages/Signup.jsx';
import User from "./pages/Usermodules/User.jsx"
// import UserForm from "./pages/Usermodules/UserForm.jsx"
// import UserAbout from "./pages/Homepage/About.jsx"
import { Admin } from "./pages/AdminModules/Admin.jsx"
import Home from "./pages/Homemodules/Home.jsx";
// import Application from "./pages/Usermodules/userApplication.jsx";
import UserApplication from "./pages/Usermodules/userApplication.jsx";
import Adminapplication from "./pages/AdminModules/AdminApplication.jsx";

// const Lazyabout=lazy(()=>import("./pages/Homepage/About.jsx"))
// const Lazycontact=lazy(()=>import("./pages/Homepage/Contact.jsx"))

const App=()=>{
  const router = createBrowserRouter([
    {
      path: `/home`,
      element:<Suspense fallback={<Spinner/>}><Home/></Suspense>
    },
    // {
    //   path: `/about`,
    //   element:<Suspense fallback={<Spinner/>}><UserAbout/></Suspense>
    // },
      // {
      //   path: `/contact`,
      //   element:<Suspense fallback={<Spinner/>}><Lazycontact/></Suspense>
      // },
      {
        path: `/`,
        element:<Suspense fallback={<Spinner/>}><Home/></Suspense>
      },
    {
      path: `/login`,
      element:<Suspense fallback={<Spinner/>}><Login/></Suspense>
    },
    {
      path: `/signup`,
      element:<Suspense fallback={<Spinner/>}><Signup/></Suspense>
    },
    {
      path:`/user`,
      element:<Suspense fallback={<Spinner/>}><User/></Suspense>
    },
    {
      path:`/admin`,
      element:<Suspense fallback={<Spinner/>}><Admin/></Suspense>
    },
    {
      path:`/userapplication`,
      element:<Suspense fallback={<Spinner/>}><UserApplication/></Suspense>
    },
    {
      path:`/adminapplication`,
      element:<Suspense fallback={<Spinner/>}><Adminapplication/></Suspense>
    }
  ])

    return (
    <RouterProvider router={router}/>
  )
}

export default App;