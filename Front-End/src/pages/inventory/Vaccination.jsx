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
import InputLabel from "@mui/material/InputLabel";
import FormControl from "@mui/material/FormControl";
import NativeSelect from "@mui/material/NativeSelect";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Divider from "@mui/material/Divider";
import Grid from "@mui/material/Grid";
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

const VACCINATION_URL = "/vacunacion";

export const Vaccination = () => {
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

  const getRol = async () => {
    try {
      await axios
        .get(VACCINATION_URL)
        .then((response) => setData(response?.data?.data));
      console.log(data);
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    getRol();
  }, []);

  const handleSubmitSave = async (idUser) => {
    try {
      await axios.post(`${VACCINATION_URL}/${idUser}`, form);
      setForm({});
      handleModal();
      getRol();
    } catch (err) {
      console.log(err);
    }
  };

  const getOneItem = async (id, edit) => {
    try {
      await axios
        .get(`${VACCINATION_URL}/${id}`)
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
      await axios.put(`${VACCINATION_URL}/${id}`, editItem);
      setEditItem({});
      handleEdit();
      getRol();
    } catch (err) {
      console.log(err);
    }
  };

  const handleSubmitDelete = async (id) => {
    try {
      await axios.delete(`${VACCINATION_URL}/${id}`);
      setEditItem({});
      handleConfirm();
      getRol();
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
          <Typography>Crear Vacunacion</Typography>
        </Box>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <StyledTableCell>ID</StyledTableCell>
                <StyledTableCell align="center">USUARIO</StyledTableCell>
                <StyledTableCell align="center"># DOSIS</StyledTableCell>
                <StyledTableCell align="center">VACUNA</StyledTableCell>
                <StyledTableCell align="center">FECHA</StyledTableCell>
                <StyledTableCell align="center">ACCIONES</StyledTableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data.map((data) => (
                <StyledTableRow key={data.id}>
                  <StyledTableCell component="th" scope="row">
                    {data.id}
                  </StyledTableCell>
                  <StyledTableCell align="center">
                    {data.userName}
                  </StyledTableCell>
                  <StyledTableCell align="center">{data.doses}</StyledTableCell>
                  <StyledTableCell align="center">
                    {data.vaccineName}
                  </StyledTableCell>
                  <StyledTableCell align="center">{data.date}</StyledTableCell>

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
              Guardar nueva vacunacion
            </Typography>
            <Divider />
            <Grid container spacing={2}>
              <Grid item xs={4}>
                <Item>id Usuario</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Nombre"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idUser"
                    value={form.idUser}
                    onChange={handlechange}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>Fecha</Item>
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
                <Item>Dosis</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="# de dosis"
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
                <Item>id Vacuna</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="id de vacuna"
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
              <Button onClick={handleModal}>Cancelar</Button>
              <Button onClick={() => handleSubmitSave(form.idUser)}>Guardar</Button>
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
                <Item>id usuario</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Nombre"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idUser"
                    value={editItem.idUser}
                    onChange={handlechangeEdit}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>dosis</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="# de dosis"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="doses"
                    value={editItem.doses}
                    onChange={handlechangeEdit}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>fecha</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Fecha de vacunacion"
                    required
                    autofocus
                    fullWidth
                    type={"date"}
                    name="date"
                    value={editItem.date}
                    onChange={handlechangeEdit}
                  />
                </Item>
              </Grid>
              <Grid item xs={4}>
                <Item>id vaccuna</Item>
              </Grid>
              <Grid item xs={8}>
                <Item>
                  <TextField
                    label="Nombre"
                    required
                    autofocus
                    fullWidth
                    type={"number"}
                    name="idVaccine"
                    value={editItem.idVaccine}
                    onChange={handlechangeEdit}
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
