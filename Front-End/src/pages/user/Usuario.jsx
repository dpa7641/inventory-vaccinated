import { Box, IconButton, Typography } from "@mui/material";
import Paper from "@mui/material/Paper";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import CreateIcon from "@mui/icons-material/Create";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";
import DeleteIcon from "@mui/icons-material/Delete";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Divider from "@mui/material/Divider";
import Grid from "@mui/material/Grid";
import MenuItem from "@mui/material/MenuItem";
import { useEffect, useState } from "react";
import axios from "../../api/axios";

const style = {
  position: "absolute",
  top: "40%",
  left: "50%",
  transform: "translate(-40%, -40%)",
  width: 700,
  border: "7px solid #000",
  bgcolor: "background.paper",
  pt: 3,
  px: 4,
  pb: 3,
};
const Item = styled(Paper)(({ theme }) => ({
  padding: theme.spacing(1),
  textAlign: "center",
  color: theme.palette.text.secondary,
}));

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));

const USUARIO_URL = "/usuario";
const vacunado = [
  {
    value: true,
    label: "Si",
  },
  {
    value: false,
    label: "No",
  },
];

export const Usuario = () => {
  const [data, setData] = useState([]);
  const [open, setOpen] = useState(false);
  const [form, setForm] = useState({});
  const [openConfirm, setOpenConfirm] = useState(false);
  const [openEdit, setOpenEdit] = useState(false);
  const [editItem, setEditItem] = useState({});
  const handleModal = () => {
    setOpen(!open);
  };
  const handleConfirm = () => {
    setOpenConfirm(!openConfirm);
  };
  const handleEdit = () => {
    setOpenEdit(!openEdit);
  };
  const handlechangeEdit = (e) => {
    setEditItem({
      ...editItem,
      [e.target.name]: e.target.value,
    });
    console.log(form);
  };

  const handlechange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
    console.log(form);
  };

  const getUser = async () => {
    try {
      await axios
        .get(USUARIO_URL)
        .then((response) => setData(response?.data?.data));
      console.log(data);
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    getUser();
  }, []);

  const handleSubmitSave = async () => {
    try {
      await axios.post(USUARIO_URL, form);
      setForm({});
      handleModal();
      getUser();
    } catch (err) {
      console.log(err);
    }
  };

  const getOneItem = async (id, edit) => {
    try {
      await axios
        .get(`${USUARIO_URL}/${id}`)
        .then((response) => setEditItem(response?.data?.data));
      if (edit === true) {
        handleEdit();
      } else {
        handleConfirm();
      }
    } catch (err) {
      console.log(err);
    }
  };

  const handleSubmitUpdate = async (id) => {
    try {
      await axios.put(`${USUARIO_URL}/${id}`, editItem);
      setEditItem({});
      handleEdit();
      getUser();
    } catch (err) {
      console.log(err);
    }
  };

  const handleSubmitDelete = async (id) => {
    try {
      await axios.delete(`${USUARIO_URL}/${id}`);
      setEditItem({});
      handleConfirm();
      getUser();
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <Box sx={{ display: "flex", flexDirection: "column" }}>
        <Box displey="flex" justifyContent="space-between">
          <IconButton onClick={handleModal}>
            <AddCircleOutlineIcon />
          </IconButton>
          <Typography>Crear Usuario</Typography>
        </Box>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <StyledTableCell>ID</StyledTableCell>
                <StyledTableCell>NOMBRE</StyledTableCell>
                <StyledTableCell>CI</StyledTableCell>
                <StyledTableCell>EMAIL</StyledTableCell>
                <StyledTableCell>CUMPLEAÑOS</StyledTableCell>
                <StyledTableCell>TELEFONO</StyledTableCell>
                <StyledTableCell>VACUNADO</StyledTableCell>
                <StyledTableCell>ROL</StyledTableCell>
                <StyledTableCell>ACCIONES</StyledTableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data.map((data) => (
                <StyledTableRow key={data.id}>
                  <StyledTableCell component="th" scope="row">
                    {data.id}
                  </StyledTableCell>
                  <StyledTableCell>
                    {data.name} {data.lastName}
                  </StyledTableCell>
                  <StyledTableCell>{data.ci}</StyledTableCell>
                  <StyledTableCell>{data.email}</StyledTableCell>
                  <StyledTableCell>{data.birthdate}</StyledTableCell>
                  <StyledTableCell>{data.phone}</StyledTableCell>
                  {data.vaccinated ? (
                    <StyledTableCell>Si</StyledTableCell>
                  ) : (
                    <StyledTableCell>No</StyledTableCell>
                  )}
                  <StyledTableCell>{data.rolName}</StyledTableCell>
                  <StyledTableCell align="center">
                    <IconButton onClick={() => getOneItem(data.id, true)}>
                      <CreateIcon />
                    </IconButton>
                    <IconButton onClick={() => getOneItem(data.id, false)}>
                      <DeleteIcon />
                    </IconButton>
                  </StyledTableCell>
                </StyledTableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
      <>
        <Modal
          open={open}
          onClose={handleModal}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              Guardar un Usuario
            </Typography>
            <Divider />
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <Item>Nombre(s)</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Nombre(s)"
                    required
                    autofocus
                    fullWidth
                    type={"text"}
                    name="name"
                    value={form.name}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Apellido(s)</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Apellido(s)"
                    required
                    autofocus
                    fullWidth
                    type={"text"}
                    name="lastName"
                    value={form.lastName}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>CI</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Carnet de Identidad"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="ci"
                    value={form.ci}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Correo</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Correo electronico"
                    required
                    autofocus
                    fullWidth
                    type={"email"}
                    name="email"
                    value={form.email}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Rol</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Rol"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idRol"
                    value={form.idRol}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
            </Grid>
            <Divider />
            <Box align="right">
              <Button onClick={handleModal}>Cancelar</Button>
              <Button onClick={handleSubmitSave}>Guardar</Button>
            </Box>
          </Box>
        </Modal>
        <Modal
          open={openEdit}
          onClose={handleEdit}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              Editar {editItem.name}
            </Typography>
            <Divider />
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <Item>Nombre(s)</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Nombre(s)"
                    required
                    autofocus
                    fullWidth
                    type={"text"}
                    name="name"
                    value={form.name}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Apellido(s)</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Apellido(s)"
                    required
                    autofocus
                    fullWidth
                    type={"text"}
                    name="lastName"
                    value={form.lastName}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>CI</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Carnet de Identidad"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="ci"
                    value={form.ci}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Correo</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Correo electronico"
                    required
                    autofocus
                    fullWidth
                    type={"email"}
                    name="email"
                    value={form.email}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Rol</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Rol"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idRol"
                    value={form.idRol}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>

              <Grid item xs={4}>
                <Item>Vacunado</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    select
                    label="Vacunado"
                    defaultValue="no"
                    variant="standard"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idRol"
                    value={form.idRol}
                    onChange={handlechange}
                  >
                    {vacunado.map((option) => (
                      <MenuItem key={option.value} value={option.value}>
                        {option.label}
                      </MenuItem>
                    ))}
                  </TextField>
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>fecha de vacunacion</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    required
                    autofocus
                    fullWidth
                    type={"date"}
                    name="date"
                    value={form.date}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>doses</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Rol"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="doses"
                    value={form.doses}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>vacuna</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="nombre de vacuna"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idVaccine"
                    value={form.idVaccine}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
            </Grid>
            <Divider />
            <Box align="right">
              <Button onClick={handleEdit}>Cancelar</Button>
              <Button onClick={() => handleSubmitUpdate(editItem.id)}>
                Editar
              </Button>
            </Box>
          </Box>
        </Modal>
        <Modal
          open={openConfirm}
          onClose={handleConfirm}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              ¿Esta seguro que quieres eliminar este registro?
            </Typography>
            <Typography id="modal-modal" variant="h4" component="h2">
              {editItem.name}
            </Typography>
            <Box align="right">
              <Button onClick={handleConfirm}>Cancelar</Button>
              <Button onClick={() => handleSubmitDelete(editItem.id)}>
                Eliminar
              </Button>
            </Box>
          </Box>
        </Modal>
      </>
    </>
  );
};
