import DashboardIcon from "@mui/icons-material/Dashboard";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import CategoryIcon from "@mui/icons-material/Category";
import PersonIcon from "@mui/icons-material/Person";
import SportsEsportsIcon from "@mui/icons-material/SportsEsports";
import { Usuario } from "../pages/user/Usuario";
import { Rol } from "../pages/user/Rol";
import { Vaccine } from "../pages/inventory/Vaccine";
import { Vaccination } from "../pages/inventory/Vaccination";
import { Main } from "../pages/home/Main";
import { Config } from "../pages/user/Config";

export const DataMenu = [
  {
    id: 1,
    title: "Principal",
    icon: <DashboardIcon />,
    link: "main",
    component: <Main />,
  },
  {
    id: 2,
    title: "vacunas",
    icon: <ShoppingCartIcon />,
    link: "vaccine",
    component: <Vaccine />,
  },
  {
    id: 3,
    title: "vacunaciones",
    icon: <CategoryIcon />,
    link: "vaccination",
    component: <Vaccination />,
  },
  {
    id: 4,
    title: "Rol",
    icon: <SportsEsportsIcon />,
    link: "rol",
    component: <Rol />,
  },
  {
    id: 5,
    title: "Usuario",
    icon: <PersonIcon />,
    link: "usuario",
    component: <Usuario />,
  },
  {
    id: 6,
    title: "Configuracion",
    icon: <PersonIcon />,
    link: "config",
    component: <Config />,
  },
];
